import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        Long[] answer = new Long[n];
        Arrays.fill(answer, (long) -1);
        answer[0] = (long) 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<n; i++) {
            int jump = arr[i];
            if (answer[i] == -1) continue;

            for (int j=1;j<=jump; j++) {
                int next = i + j;
                if (next >= n) {
                    continue;
                }
                if (answer[next] == -1) {
                    answer[next] = answer[i] + 1;
                } else {
                    answer[next] = Math.min(answer[next], answer[i] + 1);
                }
            }
        }

        System.out.println(answer[n-1]);

    }
}
