import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] dp = new int[K+1];
        Arrays.fill(dp, 100001);
        dp[0] = 0;

        for (int i=0; i<N; i++) {
            int coin = Integer.parseInt(br.readLine());
            for (int j=coin; j<=K; j++) {
                dp[j] = Math.min(dp[j-coin] + 1, dp[j]);
            }
        }

        if (dp[K] == 100001) System.out.println(-1);
        else System.out.println(dp[K]);
    }
}