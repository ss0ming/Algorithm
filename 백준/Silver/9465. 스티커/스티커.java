import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());


        for (int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] arr = new int[2][n+1];
            long[][] dp = new long[2][n+1];
            for (int j = 0; j < 2; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int k = 1; k <= n; k++) {
                    arr[j][k] = Integer.parseInt(st.nextToken());
                }
            }

            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            for (int a = 2; a <= n; a++) {
                dp[0][a] = Math.max(dp[1][a - 1], dp[1][a - 2]) + arr[0][a];
                dp[1][a] = Math.max(dp[0][a - 1], dp[0][a - 2]) + arr[1][a];
            }
            System.out.println(Math.max(dp[0][n], dp[1][n]));
        }
    }

}