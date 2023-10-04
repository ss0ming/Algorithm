import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 1;

        while (A != B) {
            if (A > B) {
                answer = -1;
                break;
            }
            String s = Integer.toString(B);
            if (B % 2 == 0) {
                B /= 2;
            } else if (s.charAt(s.length()-1) == '1') {
                B /= 10;
            } else {
                answer = -1;
                break;
            }
            answer++;
        }

        System.out.println(answer);

    }

}