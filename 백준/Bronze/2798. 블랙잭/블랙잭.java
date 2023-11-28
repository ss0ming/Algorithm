import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;
    static int answer = -1;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        back(0, visited, 0, 0);

        System.out.println(answer);
    }

    public static void back (int cur, boolean[] visited, int cnt, int sum) {
        if (cnt == 3) {
            if (sum <= M && sum > answer) answer = sum;
            return;
        }

        for (int i=cur; i<visited.length; i++) {
            visited[i] = true;
            back(i+1, visited, cnt+1, sum + arr[i]);
            visited[cur] = false;
        }
    }
}