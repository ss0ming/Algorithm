import java.io.*;
import java.util.*;

public class Main {

    static boolean[][] visited = new boolean[1001][1001];

    public static class Screen {
        int clipboard;
        int total;
        int time;

        public Screen(int clipboard, int total, int time) {
            this.clipboard = clipboard;
            this.total = total;
            this.time = time;
        }
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        bfs(n);

    }

    public static void bfs(int n) {
        Queue<Screen> q = new LinkedList<>();
        visited[0][1] = true;
        q.add(new Screen(0, 1, 0));

        while (!q.isEmpty()) {
            Screen cur = q.poll();

            if (cur.total == n) {
                System.out.println(cur.time);
                return;
            }

            // 이모티콘 복사
            q.offer(new Screen(cur.total, cur.total, cur.time + 1));

            // 클립보드에 있는 이모티콘 붙여넣기
            if (cur.clipboard != 0 && cur.clipboard + cur.total <= n && !visited[cur.clipboard][cur.clipboard + cur.total]) {
                q.offer(new Screen(cur.clipboard, cur.clipboard + cur.total, cur.time + 1));
                visited[cur.clipboard][cur.clipboard + cur.total] = true;
            }

            // 이모티콘 하나 삭제
            if (cur.total >= 1 && !visited[cur.clipboard][cur.total - 1]) {
                q.offer(new Screen(cur.clipboard, cur.total - 1, cur.time + 1));
                visited[cur.clipboard][cur.total - 1] = true;
            }
        }
    }
}