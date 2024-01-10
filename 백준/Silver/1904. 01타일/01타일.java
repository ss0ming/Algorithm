import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        long ans = 0;

        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<dp.length; i++) {
            dp[i] = (dp[i-2] + dp[i-1]) % 15746;
        }

        System.out.println(dp[N]);
    }

}