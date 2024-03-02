import java.io.*;
import java.util.*;

public class Main {

    static int[] coins;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int total = Integer.parseInt(st.nextToken());
        coins = new int[n];

        for (int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        for (int i=n-1; i>=0; i--) {
            if (total / coins[i] > 0) {
                answer += total / coins[i];
                total = total % coins[i];
            }
        }

        System.out.println(answer);
    }
}
