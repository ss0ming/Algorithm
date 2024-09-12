import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        String[] arr = input.split("");
        boolean[] visited = new boolean[N];
        int answer = 0;

        for (int i=0; i<N; i++) {
            if (!arr[i].equals("P")) continue;
            for (int j=-K; j<=K; j++) {
                if (isPromising(i+j, N) && arr[i+j].equals("H") && !visited[i+j]) {
                    visited[i+j] = true;
                    answer++;
                    break;
                }
            }
        }

        System.out.println(answer);

    }

    public static boolean isPromising(int x, int n) {
        return x >= 0 && x < n;
    }
}