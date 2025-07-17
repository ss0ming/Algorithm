import java.util.*;

class Solution {
    
    static int[] ryan = {-1};
    static int max = 0;
    static int[] res = new int[11];
    
    public int[] solution(int n, int[] info) {
        dfs(0, n, info);
        
        if(max==-1) {
        	ryan = new int[1];
        	ryan[0]=-1;
        }
        return ryan;
    }

    private void dfs(int d, int n, int[] info) {
        if (d == n) {
            int scoreDiff = diff(info);
            if (scoreDiff >= max) {
                max = scoreDiff;
                ryan = res.clone();
            }
            return;
        }
        
        for (int i=0; i<11 && res[i] <= info[i]; i++) {
            res[i] += 1;
            dfs(d+1, n, info);
            res[i] -= 1;
        }
    }
    
    private int diff(int[] info) {
        int r = 0;
        int a = 0;
        
        for (int i=0; i<11; i++) {
            if (info[i] == 0 && res[i] == 0) {
                continue;
            } else if (res[i] > info[i]) {
                r += (10-i);
            } else {
                a += (10-i);
            }
        }
        
        int tmp = r - a;
        
        if (tmp <= 0) return -1;
        return tmp;
    }
}