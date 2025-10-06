import java.util.*;

class Solution {
    public class Node {
        int x;
        int y;
        int dis;
        String route;

        public Node(int x, int y, int dis, String route) {
            this.x = x;
            this.y = y;
            this.dis = dis;
            this.route = route;
        }
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, -1, 1, 0};
    static String[] dd = {"d", "l", "r", "u"};

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        String answer = "impossible";

        PriorityQueue<Node> q = new PriorityQueue<>((o1, o2) -> o1.route.compareTo(o2.route));
        PriorityQueue<String> pq = new PriorityQueue<>();

        x -= 1; y -= 1;
        r -= 1; c -= 1;

        q.add(new Node(x, y, 0, ""));

        while (!q.isEmpty()) {
            Node cur = q.poll();

            // 1️⃣ 종료 조건
            if (cur.x == r && cur.y == c && cur.dis == k) {
                pq.add(cur.route);
                break;
            }

            // 2️⃣ 이동 횟수 초과 시 중단
            if (cur.dis >= k) continue;

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (!inRange(nx, ny, n, m)) continue;

                int newDis = cur.dis + 1;
                int remain = k - newDis;

                // ✅ 가지치기 로직 추가
                int manhattan = Math.abs(r - nx) + Math.abs(c - ny);
                // 남은 이동 횟수로 도달 불가능하거나
                // 남은 이동 횟수 - 거리 차이가 홀수이면 불가능 (패리티 불일치)
                if (manhattan > remain || (remain - manhattan) % 2 != 0) continue;

                q.add(new Node(nx, ny, newDis, cur.route + dd[i]));
            }
        }

        if (pq.isEmpty()) return answer;
        return pq.poll();
    }

    private static boolean inRange(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}