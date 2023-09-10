import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            if (i == 0) {
                arr[i] = Integer.parseInt(st.nextToken());
            } else {
                arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;

        for (int i=0; i<N; i++) {
            if (i == N-1 && arr[i] == M) {
                cnt++;
                break;
            } else if (arr[i] == M) {
                cnt++;
            }

            for (int j=i+1; j<N; j++) {
                if (arr[j] - arr[i] == M) {
                    cnt++;
                    break;
                } else if (arr[j] - arr[i] > M) {
                    break;
                }
            }
        }
        bw.write(cnt+"");
        bw.close();
    }
}