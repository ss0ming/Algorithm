import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            if (N == 0) break;

            int[] arr = new int[N+1];
            boolean[] visited = new boolean[N+1];

            for (int i=1; i<arr.length; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            back(1, 0, arr, visited);
            System.out.println();
        }
    }

    public static void back(int x, int cnt, int[] arr, boolean[] visited) {
        if (cnt == 6) {
            print(arr, visited);
            return;
        }

        for (int i=x; i<arr.length; i++) {
            visited[i] = true;
            back(i+1, cnt+1, arr, visited);
            visited[i] = false;
        }
    }

    public static void print(int[] arr, boolean[] visited) {
        for (int i=1; i<visited.length; i++) {
            if (visited[i]) System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}