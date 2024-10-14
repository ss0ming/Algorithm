import java.io.*;
import java.util.*;

public class Main {

    static int answer = 0;
    static int N;
    static int[] arr;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        visited = new boolean[N];
        int[] tmp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0, tmp);

        System.out.println(answer);
    }

    public static void back(int cnt, int[] tmp) {
        if (cnt == N) {
            int res = 0;

            for (int i=1; i<N; i++) {
                res += Math.abs(tmp[i] - tmp[i-1]);
            }

            answer = Math.max(res, answer);
        }

        for (int i=0; i<N; i++) {
            if (!visited[i]) {
                tmp[cnt] = arr[i];
                visited[i] = true;
                back(cnt+1, tmp);
                visited[i] = false;
            }
        }
    }
}