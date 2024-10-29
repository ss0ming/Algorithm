import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Integer[] ropes = new Integer[N];

        for (int i=0; i<N; i++) {
            ropes[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(ropes, Collections.reverseOrder());

        int answer = 0;
        for (int i=0; i<N; i++) {
            int tmp = ropes[i] * (i + 1);
            if (answer < tmp) {
                answer = tmp;
            }
        }

        System.out.println(answer);
    }
}