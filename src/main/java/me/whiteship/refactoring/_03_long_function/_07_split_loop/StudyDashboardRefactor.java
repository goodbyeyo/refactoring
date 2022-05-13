package me.whiteship.refactoring._03_long_function._07_split_loop;

import org.kohsuke.github.GHIssue;
import org.kohsuke.github.GHIssueComment;
import org.kohsuke.github.GHRepository;
import org.kohsuke.github.GitHub;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudyDashboardRefactor {

    private final int totalNumberOfEvents;
    private final List<Participant> participants;
    private final Participant[] firstParticipantsForEachEvent;
    private List<Participant> participantList;
    private Participant[] participantsForEachEvent;

    public StudyDashboardRefactor(int totalNumberOfEvents) {
        this.totalNumberOfEvents = totalNumberOfEvents;
        participants = new CopyOnWriteArrayList<>();
        firstParticipantsForEachEvent = new Participant[this.totalNumberOfEvents];
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        StudyDashboardRefactor studyDashboard = new StudyDashboardRefactor(15);
        studyDashboard.print();
    }

    private void print() throws IOException, InterruptedException {
        GHRepository ghRepository = getGhRepository();

        /**
         * new participants 가 생기는 경우 add가 일어나는데 concurrent modification safe colletion
         * CopyOnWriteArrayList<E>
         */
//        participantList = new CopyOnWriteArrayList<>();
//        participantsForEachEvent = new Participant[this.totalNumberOfEvents];
        
        // 멀티 쓰레드 프로그래밍(총 8개의 쓰레드풀)
        ExecutorService service = Executors.newFixedThreadPool(8);
        // 총 15개의 쓰레드가 동작(totalNumberOfEvents:15개)
        CountDownLatch latch = new CountDownLatch(totalNumberOfEvents);

        checkGithubIssuse(ghRepository, participantsForEachEvent, service, latch);
        new StudyPrinter(this.totalNumberOfEvents, this.participants).execute();
        printFirstParticipants();   //프리트 작업
    }

    private void checkGithubIssuse(GHRepository ghRepository, Participant[] firstParticipantsForEachEvent, ExecutorService service, CountDownLatch latch) throws InterruptedException, IOException {
        for (int index = 1 ; index <= totalNumberOfEvents ; index++) {
            int eventId = index;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        GHIssue issue = ghRepository.getIssue(eventId);
                        List<GHIssueComment> comments = issue.getComments();
                        checkHomework(comments, eventId);
                        firstParticipantsForEachEvent[eventId - 1] = findFirst(comments);
                        latch.countDown();  // 끝날때마다 낮춤
                    } catch (IOException e) {
                        throw new IllegalArgumentException(e);
                    }
                }
            });
        }
        latch.await();  // 다될때까지 기다렸다가
        service.shutdown(); // exucute 서비스정리
    }

    private Participant findFirst(List<GHIssueComment> comments) throws IOException {
        Date firstCreatedAt = null;
        Participant first = null;
        for (GHIssueComment comment : comments) {
            Participant participant = findParticipant(comment.getUserName(), participants);

            if (firstCreatedAt == null || comment.getCreatedAt().before(firstCreatedAt)) {
                firstCreatedAt = comment.getCreatedAt();
                first = participant;
            }
        }
        return first;
    }

    private void checkHomework(List<GHIssueComment> comments, int eventId) {
        for (GHIssueComment comment : comments) {
            Participant participant = findParticipant(comment.getUserName(), participants);
            participant.setHomeworkDone(eventId);
        }
    }

    private void printFirstParticipants() {
        Arrays.stream(this.firstParticipantsForEachEvent).forEach(p -> System.out.println(p.username()));
    }

    private GHRepository getGhRepository() throws IOException {
        GitHub gitHub = GitHub.connect();
        GHRepository repository = gitHub.getRepository("whiteship/live-study");
        return repository;
    }

    private Participant findParticipant(String username, List<Participant> participants) {
        return isNewParticipant(username, participants) ?
                createNewParticipant(username, participants) :
                findExistingParticipant(username, participants);
    }

    private Participant findExistingParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = participants.stream().filter(p -> p.username().equals(username)).findFirst().orElseThrow();
        return participant;
    }

    private Participant createNewParticipant(String username, List<Participant> participants) {
        Participant participant;
        participant = new Participant(username);
        participants.add(participant);
        return participant;
    }

    private boolean isNewParticipant(String username, List<Participant> participants) {
        return participants.stream().noneMatch(p -> p.username().equals(username));
    }

}
