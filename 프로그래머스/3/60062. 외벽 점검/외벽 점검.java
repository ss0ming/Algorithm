import java.util.*;

class Solution {
    static int len, friends;
    static int[] intervals;
    static ArrayList<int[]> perm = new ArrayList<>();

    public static int solution(int n, int[] weak, int[] dist) {
        len = weak.length;
        intervals = new int[len];

        for (int i=0; i<len-1; i++)
            intervals[i] = weak[i+1] - weak[i];
        intervals[len-1] = weak[0] + n - weak[len-1];

        Arrays.sort(dist);
        friends = dist.length;

        boolean[] isVisited = new boolean[friends];
        for (int i=1; i<=friends; i++)
            perm(new int[i], i, 0, isVisited, dist);

        for (int[] p : perm)
            for (int i=0; i<len; i++)   
                if (isValid(i, p)) 
                    return p.length;

        return -1;
    }

    private static void perm(int[] p, int limit, int depth, boolean[] isVisited, int[] dist) {
        if (limit == depth) {
            perm.add(p.clone());
            return;
        }

        for (int i=friends-1; i>=friends-limit; i--) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                p[depth] = dist[i];
                perm(p, limit, depth+1, isVisited, dist);
                isVisited[i] = false;
            }
        }
    }

    private static boolean isValid(int i, int[] p) {            
        int cnt = 0;
        for (int d : p) {
            while (d - intervals[i%=len] >= 0) {
                d -= intervals[i++];
                cnt++;
            }
            i++;
            cnt++;

            if (cnt >= len)
                return true;
        }

        return false;
    }
}