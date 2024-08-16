import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        int[] dp = new int[N+1];
        List<Integer> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i=1; i<N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = arr[1];
        for (int i=2; i<X+1; i++) {
            dp[i] = arr[i] + dp[i-1];
        }
        list.add(dp[X]);

        for (int i=X+1; i<N+1; i++) {
            dp[i] = dp[i-1] + arr[i] - arr[i-X];
            list.add(dp[i]);
        }

        Collections.sort(list);

        if (list.get(list.size() - 1) == 0) {
            System.out.println("SAD");
            return;
        }

        int result = list.get(list.size() - 1);
        long count = list.stream()
                .filter(i -> i == result)
                .count();

        System.out.println(result);
        System.out.println(count);
    }
}