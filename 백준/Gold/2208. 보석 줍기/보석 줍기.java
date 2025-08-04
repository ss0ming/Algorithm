import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] arr = new long[N];
        long[] sum = new long[N];
        long[] dp = new long[N];

        arr[0] = Integer.parseInt(br.readLine());
        sum[0] = arr[0];
        for (int i=1; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum[i] = sum[i-1] + arr[i];
        }

        long answer = dp[M-1];
        dp[M-1] = sum[M-1];
        for (int i=M; i<N; i++) {
            dp[i] = Math.max(dp[i-1] + arr[i], sum[i] - sum[i-M]);
            answer = Math.max(answer, dp[i]);
        }

        if (answer < 0) answer = 0;

        System.out.println(answer);
    }
}