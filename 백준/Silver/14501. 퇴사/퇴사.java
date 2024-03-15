import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] days = new int[n];
        int[] amounts = new int[n];
        int[] dp = new int[n+1];

        for (int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            amounts[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            if(i + days[i] <= n) {
                dp[i+days[i]] = Math.max(dp[i+days[i]], dp[i] + amounts[i]);
            }
            dp[i+1] = Math.max(dp[i+1], dp[i]);
        }

        System.out.println(dp[n]);
    }

}