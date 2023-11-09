import java.io.*;
import java.util.*;

public class Main {

    static int F;
    static int S;
    static int G;
    static int[] dir;
    static int[] answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken()); // 총 층수
        S = Integer.parseInt(st.nextToken()); // 강호가 있는 층
        G = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 층
        int U = Integer.parseInt(st.nextToken()); // 위로 가는 버튼
        int D = Integer.parseInt(st.nextToken()); // 아래로 가는 버튼
        dir = new int[]{U, -D};
        answer = new int[F+1];

        answer[S] = 1;
        bfs(S);

        if (answer[G] == 0)
            System.out.println("use the stairs");
        else System.out.println(answer[G] - 1);
    }

    public static void bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);

        while (!q.isEmpty()) {
            int curFloor = q.poll();

            for (int i=0; i<2; i++) {
                int nextFloor = curFloor + dir[i];

                if (!isPromising(nextFloor)) continue;
                answer[nextFloor] = answer[curFloor] + 1;
                q.add(nextFloor);
            }
        }
    }

    public static boolean isPromising(int floor) {
        if (floor <= 0 || floor > F) return false;
        return answer[floor] == 0;
    }
}