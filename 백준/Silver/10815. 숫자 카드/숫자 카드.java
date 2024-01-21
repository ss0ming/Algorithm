import java.io.*;
import java.util.*;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] sanggeun = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sanggeun[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sanggeun);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<M; i++) {
            System.out.print(checkArr(sanggeun, Integer.parseInt(st.nextToken())) + " ");
        }
    }

    public static int checkArr(int[] arr, int n) {
        int l = 0;
        int r = arr.length - 1;
        int m = (l + r) / 2;

        while (l <= r) {
            if (arr[m] == n) return 1;
            else if (arr[m] < n) {
                l = m+1;
                m = (l + r) / 2;
            } else if (arr[m] > n) {
                r = m-1;
                m = (l + r) / 2;
            }

        }
        return 0;
    }
}