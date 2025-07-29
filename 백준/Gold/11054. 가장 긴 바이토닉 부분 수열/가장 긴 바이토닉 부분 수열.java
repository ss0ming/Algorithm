import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp1 = new int[N];
        int[] dp2 = new int[N];

        for (int i=0; i<N; i++) {
            dp1[i] = 1;
            for (int j=0; j<i; j++) {
                if (A[i] > A[j]) {
                    dp1[i] = Math.max(dp1[j] + 1, dp1[i]);
                }
            }
        }

        for (int i=N-1; i>=0; i--) {
            dp2[i] = 1;
            for (int j=N-1; j>i; j--) {
                if (A[i] > A[j]) {
                    dp2[i] = Math.max(dp2[j] + 1, dp2[i]);
                }
            }
        }

        int answer = 0;

        for (int i=0; i<N; i++) {
            answer = Math.max(answer, dp1[i] + dp2[i] - 1);
        }

        System.out.println(answer);
    }
}