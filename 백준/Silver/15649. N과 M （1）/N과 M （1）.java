import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int M;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N+1];

        for (int i=1; i<N+1; i++) {
            List<Integer> list = new ArrayList<>();
            list.add(i);
            visited[i] = true;
            dfs(list, visited, 1);
            visited[i] = false;
        }


    }

    public static void dfs(List<Integer> list, boolean[] visited, int cnt) {
        if (cnt == M) {
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i=1; i<N+1; i++) {
            if (!visited[i]) {
                visited[i] = true;
                list.add(i);
                dfs(list, visited, cnt+1);
                list.remove(cnt);
                visited[i] = false;
            }
        }
    }
}