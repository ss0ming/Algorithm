import java.io.*;
import java.util.*;

public class Main {

    static int[] apple;
    static int[] visited;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int k;
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        apple = new int[n];
        visited = new int[n];

        for (int i=0; i<n; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i=0; i<n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(p).add(c);
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            apple[i] = Integer.parseInt(st.nextToken());
        }

        visited[0] = 1;
        if (apple[0] == 1) answer++;
        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs (int v, int depth) {
        if (depth == k) {
            return;
        }
        for (int i=0; i<graph.get(v).size(); i++) {
            if (visited[graph.get(v).get(i)] == 1) continue;
            if (apple[graph.get(v).get(i)] == 1) answer++;
            visited[graph.get(v).get(i)] = 1;
            dfs(graph.get(v).get(i), depth+1);
        }
    }
}