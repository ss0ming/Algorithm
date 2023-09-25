import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static boolean[][] visited;
    static int[] dx = {0, 1};
    static int[] dy = {1, 0};

    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        visited = new boolean[n][n];

        StringTokenizer st;

        for (int i=0; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);

        System.out.println("Hing");
    }

    static void dfs(int nodeIdxX, int nodeIdxY) {
        //System.out.println("x, y: " + nodeIdxX + ", " + nodeIdxY);
        visited[nodeIdxX][nodeIdxY] = true;
        if (nodeIdxX == n-1 && nodeIdxY == n-1) {
            System.out.println("HaruHaru");
            System.exit(0);
        }

        for (int k=0; k<2; k++) {
            int x = nodeIdxX + graph[nodeIdxX][nodeIdxY] * dx[k];
            int y = nodeIdxY + graph[nodeIdxX][nodeIdxY] * dy[k];

            if ((x >= n || y >= n) || visited[x][y]) continue;

            dfs(x, y);
        }

    }

}