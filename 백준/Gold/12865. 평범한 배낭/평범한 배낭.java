import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] dp = new int[N+1][K+1];

        for (int i=1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            for (int j=1; j<=K; j++) {
                if (j < w) {
                    dp[i][j] = dp[i-1][j];
                    
                } else {
                    dp[i][j] = Math.max(dp[i-1][j-w] + v, dp[i-1][j]);
                }
                
            }
        }

        System.out.println(dp[N][K]);
    }
}