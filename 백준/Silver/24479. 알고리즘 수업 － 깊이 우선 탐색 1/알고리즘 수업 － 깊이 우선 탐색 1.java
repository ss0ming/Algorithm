import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static int[] visited;
    static int[] answer;
    static int idx = 1;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        visited = new int[N+1];
        answer = new int[N+1];

        for (int i=0; i<N+1; i++) {
            graph.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int N1 = Integer.parseInt(st.nextToken());
            int N2 = Integer.parseInt(st.nextToken());
            graph.get(N1).add(N2);
            graph.get(N2).add(N1);
        }

        for (int i=1; i<N+1; i++) {
            Collections.sort(graph.get(i));
        }

        visited[R] = 1;
        dfs(R);
        StringBuilder sb = new StringBuilder();
        for (int i=1; i<answer.length; i++) {
            sb.append(answer[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n) {
        answer[n] = idx++;
        for (int i=0; i<graph.get(n).size(); i++) {
            if (visited[graph.get(n).get(i)] == 1) continue;
            visited[graph.get(n).get(i)] = 1;
            dfs(graph.get(n).get(i));
        }
    }
}