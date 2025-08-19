import java.util.*;

class Job {
    private int requestTime;
    private int runTime;

    public Job(int[] job) {
        this.requestTime = job[0];
        this.runTime = job[1];
    }

    public int getRequestTime() {
        return this.requestTime;
    }

    public int getRunTime() {
        return this.runTime;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;

        // 실행 시간 기준 오름차순 정렬 (최소 실행 시간 우선)
        PriorityQueue<Job> standbyQue = new PriorityQueue<>(Comparator.comparingInt(Job::getRunTime));

        // 요청 시각 기준 오름차순 정렬 (입고 시점 순서)
        PriorityQueue<Job> jobQue = new PriorityQueue<>(Comparator.comparingInt(Job::getRequestTime).thenComparingInt(Job::getRunTime));
        Arrays.stream(jobs).forEach(job -> jobQue.offer(new Job(job)));

        // 첫 작업 초기화
        standbyQue.offer(jobQue.poll());
        int endTime = standbyQue.peek().getRequestTime(); // 현재 시간

        // 대기 큐에 작업이 있는 동안 반복
        while (!standbyQue.isEmpty()) {
            // 실행할 작업 꺼내기
            Job job = standbyQue.poll();
            endTime += job.getRunTime(); // 현재 시간 증가
            answer += endTime - job.getRequestTime(); // 반환 시간 누적

            // endTime까지 도착한 작업들을 대기 큐에 추가
            while (!jobQue.isEmpty() && jobQue.peek().getRequestTime() <= endTime) {
                standbyQue.offer(jobQue.poll());
            }

            // 대기 큐가 비었고, 아직 남은 작업이 있으면 다음 작업 넣기 (시간 점프)
            if (standbyQue.isEmpty() && !jobQue.isEmpty()) {
                standbyQue.offer(jobQue.poll());
                endTime = standbyQue.peek().getRequestTime(); // 시간을 다음 작업 요청 시점으로 이동
            }
        }

        return answer / jobs.length;
    }
}