import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];

        for (int i=1; i<=N; i++) {
            if (i <= 5) {
                if (i == 3 || i == 5) arr[i] = 1;
                else arr[i] = 0;
                continue;
            }
            if (arr[i-3] == 0 && arr[i-5] == 0) continue;
            else if (arr[i-3] != 0 && arr[i-5] == 0) {
                arr[i] = arr[i-3] + 1;
            } else if (arr[i-3] == 0 && arr[i-5] != 0) {
                arr[i] = arr[i-5] + 1;
            } else {
                arr[i] = Math.min(arr[i-3], arr[i-5]) + 1;
            }
        }

        if (arr[N] == 0) System.out.println(-1);
        else System.out.println(arr[N]);
    }
}