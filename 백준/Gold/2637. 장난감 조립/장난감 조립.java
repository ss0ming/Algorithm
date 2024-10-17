import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] answer = new int[N+1];
        int[] in = new int[N+1];
        int[][] dag = new int[N+1][N+1];
        boolean[] basic = new boolean[N+1];

        for (int i=0; i<M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            dag[x][y] = k;
            in[y]++;
            basic[x] = true;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<N+1; i++) {
            if (in[i] == 0) {
                q.add(i);
                answer[i] = 1;
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i=1; i<=N; i++) {
                if (dag[cur][i] != 0) {
                    answer[i] += answer[cur] * dag[cur][i];
                    in[i]--;

                    if (in[i] == 0) {
                        q.add(i);
                    }
                }
            }
        }

        for (int i=1; i<=N; i++) {
            if (!basic[i]) {
                System.out.println(i + " " + answer[i]);
            }
        }
    }
}