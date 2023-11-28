import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] answer = {0, 1, 1};

        for (int i=0; i<9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<9; j++) {
                int cur = Integer.parseInt(st.nextToken());
                if (cur > answer[0]) {
                    answer[0] = cur;
                    answer[1] = i+1;
                    answer[2] = j+1;
                }
            }
        }

        System.out.println(answer[0]);
        System.out.println(answer[1] + " " + answer[2]);
    }
}