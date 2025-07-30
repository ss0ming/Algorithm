import java.io.*;
import java.util.*;

class Main {

    static int answer = 0;
    static int N;
    static int K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs();

        System.out.println(answer);
    }

    private static void bfs() {
        Queue<Integer> q = new LinkedList<>();
        int[] memo = new int[100001];
        q.add(N);
        memo[N] = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            
            if (cur == K) {
                answer = memo[cur] - 1;
                return;
            }
            if (cur-1 >= 0 && memo[cur-1] == 0) {
                memo[cur-1] = memo[cur] + 1;
                q.add(cur-1);
            }
            if (cur+1 <= 100000 && memo[cur+1] == 0) {
                memo[cur+1] = memo[cur] + 1;
                q.add(cur+1);
            }
            if (cur*2 <= 100000 && memo[cur*2] == 0) {
                memo[cur*2] = memo[cur] + 1;
                q.add(cur*2);
            }
        }
    }
}