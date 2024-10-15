import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] times = new int[N+1];
        int[] res = new int[N+1];
        int[] degree = new int[N+1];
        List<Integer>[] list = new ArrayList[N+1];

        for (int i=0; i<N+1; i++) {
            list[i] = new ArrayList<>();
        }

        // 입력
        for (int i=1; i<N+1; i++) {
            String[] strs = br.readLine().split(" ");
            times[i] = Integer.parseInt(strs[0]);

            for (int j=1; j<strs.length; j++) {
                int n = Integer.parseInt(strs[j]);
                if (n == -1) break;
                degree[i]++;
                list[n].add(i);
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i=1; i<=N; i++) {
            if (degree[i] == 0) {
                q.add(i);
                res[i] = times[i];
            }
        }

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i=0; i<list[cur].size(); i++) {
                int next = list[cur].get(i);
                res[next] = Math.max(res[next], res[cur] + times[next]);
                degree[next]--;
                if (degree[next] == 0) q.add(next);
            }
        }

        // 출력
        for (int i=1; i<N+1; i++) {
            System.out.println(res[i]);
        }
    }
}