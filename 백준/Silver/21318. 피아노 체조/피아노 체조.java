import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=2; i<=N; i++) {
            int check = 0;
            if (arr[i-1] > arr[i]) check = 1;
            dp[i] = dp[i-1] + check;
        }

        int Q = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<Q; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list.add(dp[y] - dp[x]);
        }

        for (Integer i : list) {
            System.out.println(i);
        }
    }
}