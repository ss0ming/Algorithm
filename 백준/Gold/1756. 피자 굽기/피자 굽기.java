import java.io.*;
import java.util.*;

public class Main {

    static int[] dArr;
    static boolean[] isExist;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int D = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        dArr = new int[D];
        isExist = new boolean[D];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<D; i++) {
            dArr[i] = Integer.parseInt(st.nextToken());
        }

        resize();
        answer = dArr.length-1;

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            pushDough(Integer.parseInt(st.nextToken()));
        }

        if (answer == 0) {
            System.out.println(answer);
        } else {
            System.out.println(answer+1);
        }
    }

    public static void pushDough(int n) {
        boolean flag = false;

        for (int i=answer; i>=0; i--) {
            if (dArr[i] >= n) {
                dArr[i] = 0;
                answer = i;
                flag = true;
                break;
            }
        }

        if (!flag) {
            answer = 0;
        }
    }

    public static void resize() {
        int dia = dArr[0];
        for (int i=1; i<dArr.length; i++) {
            if (dArr[i] > dia) {
                dArr[i] = dia;
            } else if (dArr[i] < dia) {
                dia = dArr[i];
            }
        }
    }
}