import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Map<String, Integer> answer = new HashMap<>();
        String[] hyun = new String[N];

        for (int i=0; i<N; i++) {
            answer.put(st.nextToken(), i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            hyun[i] = st.nextToken();
        }

        int result = 0;

        for (int i=0; i<N-1; i++) {
            for (int j=i+1; j<N; j++) {
                String f = hyun[i];
                String b = hyun[j];

                if (answer.get(b) - answer.get(f) > 0) {
                    result++;
                }
            }
        }

        int sum = N * (N-1) / 2;

        System.out.println(result + "/" + sum);

    }
}