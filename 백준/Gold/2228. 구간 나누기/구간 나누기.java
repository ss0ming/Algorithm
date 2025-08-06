import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int M;
    static int[] sum;
    static int[][] dp;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        sum = new int[N+1];
        dp = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];

        for (int i=1; i<=N; i++) {
            sum[i] = sum[i-1] + Integer.parseInt(br.readLine());
        }

        for (int i=0; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = Integer.MIN_VALUE / 2;
            }
        }

        dp[1][1] = sum[1];

        for (int i=2; i<=N; i++) {
            for (int j=1; j<=M; j++) {
                dp[i][j] = dp[i-1][j];

                int min = 0;
                if (j == 1) {
                    min = -1;
                }

                for (int k=i-2; k>=min; k--) {
                    if (k < 0) {
                        dp[i][j] = Math.max(dp[i][j], sum[i]);
                    } else {
                        dp[i][j] = Math.max(dp[i][j], dp[k][j-1] + sum[i] - sum[k+1]);
                    }
                }
            }
        }

        System.out.println(dp[N][M]);
    }
}