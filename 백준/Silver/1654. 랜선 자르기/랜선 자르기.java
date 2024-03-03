import java.io.*;
import java.util.*;

public class Main {
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];

        long max = 0;
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }


        long min = 1;
        long answer = 0;

        while (min <= max) {
            answer = (min + max) / 2;
            long cnt = 0;
            for (long j : arr) {
                cnt += (j / answer);
            }

            if (cnt >= k) {
                min = answer + 1;
            } else {
                max = answer - 1;
            }
        }

        System.out.println((min+max)/2);
    }
}