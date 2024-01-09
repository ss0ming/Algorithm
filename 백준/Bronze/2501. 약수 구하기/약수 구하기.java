import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;
        int i = 1;
        int answer = 0;

        while(true) {
            if (N % i == 0) cnt++;

            if (cnt == K) {
                answer = i;
                break;
            } else if (i > N) {
                break;
            }

            i++;
        }

        System.out.println(answer);
    }
}