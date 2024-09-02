import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static String[] words;
    static boolean[] alphaArr = new boolean[26];
    static int answer = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        words = new String[N];

        if (K < 5) {
            System.out.println(0);
            return;
        }

        alphaArr['a' - 'a'] = true;
        alphaArr['c' - 'a'] = true;
        alphaArr['n' - 'a'] = true;
        alphaArr['t' - 'a'] = true;
        alphaArr['i' - 'a'] = true;

        for (int i=0; i<N; i++) {
            words[i] = br.readLine();
        }

        dfs(0, 0);

        System.out.println(answer);
    }

    public static void dfs(int idx, int cnt) {
        if (cnt + 5 == K) {
            answer = Math.max(answer, check());
            return;
        }

        for (int i=idx; i<26; i++) {
            if (alphaArr[i]) {
                continue;
            }

            alphaArr[i] = true;
            dfs(i+1, cnt+1);
            alphaArr[i] = false;
        }
    }

    public static int check() {
        int cnt = 0;

        for (int i=0; i<N; i++) {
            char[] alphas = words[i].toCharArray();
            boolean flag = true;

            for (char c : alphas) {
                if (!alphaArr[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                cnt++;
            }
        }
        return cnt;
    }
}