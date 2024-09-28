import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] sanggeun = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            sanggeun[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(sanggeun);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<M; i++) {
            int m = Integer.parseInt(st.nextToken());
            isExistNum(m, sanggeun, sb);
        }

        System.out.println(sb);
    }

    public static void isExistNum(int n, int[] arr, StringBuilder sb) {
        int l = 0;
        int r = arr.length-1;
        int m = (l + r) / 2;

        while (l <= r) {
            if (arr[m] == n) {
                sb.append("1 ");
                return;
            } else if (arr[m] > n) {
                r = m-1;
                m = (l + r) / 2;
            } else if (arr[m] < n) {
                l = m+1;
                m = (l + r) / 2;
            }
        }

        sb.append("0 ");
    }
}