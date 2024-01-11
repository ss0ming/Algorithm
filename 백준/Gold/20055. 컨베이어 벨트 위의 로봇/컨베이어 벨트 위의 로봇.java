import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] arr = new int[2 * N];
        boolean[] robot = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        while (true) {
            int tmp = arr[arr.length - 1];
            for (int i = arr.length - 1; i > 0; i--) {
                arr[i] = arr[i - 1];
            }
            arr[0] = tmp;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false;
            robot[N - 1] = false;

            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && arr[i] >= 1) {
                    arr[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            if (arr[0] > 0) {
                robot[0] = true;
                arr[0]--;
            }

            ans++;

            if (K <= countK(arr)) break;
        }

        System.out.println(ans);
    }

    public static int countK(int[] arr) {
        int cnt = 0;
        for (int j : arr) {
            if (j == 0) {
                cnt++;
            }
        }
        return cnt;
    }
}