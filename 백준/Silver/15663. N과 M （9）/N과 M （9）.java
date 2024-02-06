import java.io.*;
import java.util.*;

public class Main {

    static int M, N;
    static LinkedHashSet<String> ans = new LinkedHashSet<>();
    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        boolean[] visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        back(visited, 0, "");

        for (String s : ans) {
            System.out.println(s);
        }

    }

    public static void back(boolean[] visited, int n, String str) {
        if (n == M) {
            ans.add(str);
            return;
        }

        int x = -1;
        for (int i=0; i<N; i++) {
            int now = arr[i];
            if (visited[i] || x == now) continue;
            x = now;
            visited[i] = true;
            String tmp = str + arr[i] + " ";
            back(visited, n+1, tmp);
            visited[i] = false;
        }
    }

}