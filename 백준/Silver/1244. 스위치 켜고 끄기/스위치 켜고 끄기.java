import java.io.*;
import java.util.*;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int studentN = Integer.parseInt(br.readLine());

        for (int i = 0; i < studentN; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            if (s == 1) {
                int x = num;
                while (x <= n) {
                    changeSwitch(x);
                    x += num;
                }
            } else {
                changeSwitch(num);
                int x = 1;
                while (num-x > 0 && num+x <= n) {
                    if (arr[num-x] != arr[num+x]) break;
                    changeSwitch(num-x);
                    changeSwitch(num+x);
                    x++;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(arr[i] + " ");
            if (i % 20 == 0) System.out.println();
        }
    }

    public static void changeSwitch(int idx) {
        if (arr[idx] == 1) arr[idx] = 0;
        else arr[idx] = 1;
    }
}