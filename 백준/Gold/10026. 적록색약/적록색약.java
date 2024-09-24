import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static String[][] arr;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int R = 0;
    static int G = 0;
    static int B = 0;
    static int RG = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new String[N][N];

        for (int i=0; i<N; i++) {
            String input = br.readLine();
            arr[i] = input.split("");
        }

        boolean[][] visitedOneColor = new boolean[N][N];
        boolean[][] visitedTwoColor = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!visitedOneColor[i][j]) {
                    visitedOneColor[i][j] = true;
                    findAreaOneColor(i, j, arr[i][j], visitedOneColor);
                    plusRGB(arr[i][j]);
                }
                if (!visitedTwoColor[i][j] && (arr[i][j].equals("R") || arr[i][j].equals("G")) ) {
                    visitedTwoColor[i][j] = true;
                    findAreaTwoColor(i, j, visitedTwoColor);
                    RG++;
                }
            }
        }

        System.out.print((R + G + B) + " ");
        System.out.print((RG + B));
    }

    public static void plusRGB(String color) {
        if (color.equals("R")) {
            R++;
        } else if (color.equals("G")) {
            G++;
        } else if (color.equals("B")) {
            B++;
        }
    }

    public static void findAreaOneColor(int x, int y, String color, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && !visited[nx][ny] && arr[nx][ny].equals(color)) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static void findAreaTwoColor(int x, int y, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();

            for (int i=0; i<4; i++) {
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];

                if (isPromising(nx, ny) && !visited[nx][ny] && (arr[nx][ny].equals("R") || arr[nx][ny].equals("G"))) {
                    visited[nx][ny] = true;
                    q.add(new int[]{nx, ny});
                }
            }
        }
    }

    public static boolean isPromising(int x, int y) {
        return x >= 0 && y >= 0 && x < N && y < N;
    }
}