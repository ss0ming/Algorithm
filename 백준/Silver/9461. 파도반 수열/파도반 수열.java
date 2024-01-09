import java.io.*;
import java.util.*;

public class Main {

    static long[] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        dp = new long[101];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 0; i < N; i++) {
            int A = Integer.parseInt(br.readLine());

            if (A <= 3) {
                System.out.println("1");
                continue;
            }
            System.out.println(padovan(A));
        }
    }

    public static long padovan(int a) {
        if (dp[a] < 1) dp[a] = padovan(a-3) + padovan(a-2);
        return dp[a];
    }
}