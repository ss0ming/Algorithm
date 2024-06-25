import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int n2 = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];
        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int num = n * n;
        int x = 0;
        int y = 0;
        int k = 0;
        arr[x][y] = num--;

        while (true) {
            int nx = x + dx[k];
            int ny = y + dy[k];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && arr[nx][ny] == 0) {
                arr[nx][ny] = num;
                if (num == 1) break;
                x = nx;
                y = ny;
                num--;
            } else {
                k = (k + 1) % 4;
            }
        }

        int ax = -1;
        int ay = -1;
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(arr[i][j] == n2) {
                    ax = i + 1;
                    ay = j + 1;
                }
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        sb.append(ax + " " + ay);

        System.out.println(sb);
    }
}