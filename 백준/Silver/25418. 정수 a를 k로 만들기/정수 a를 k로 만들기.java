import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        while (A != K) {
            answer++;
            if (K%2 == 0 && K/2 >= A)
                K /= 2;
            else
                K--;
        }
        System.out.println(answer);
    }
}