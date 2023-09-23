import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        int[] bridge = new int[w];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        int idxN = 0;
        int lastTruckIdx = 0;
        int sumL = 0;
        int saveN = 0;
        int answer = 0;

        while (!(idxN == n && lastTruckIdx == w)) {

            if (idxN != n && sumL + trucks[idxN] - bridge[w-1] <= l) {
                saveN = trucks[idxN];
                sumL = sumL + trucks[idxN];
                idxN++;
                lastTruckIdx = 0;
            } else {
                lastTruckIdx++;
                saveN = 0;
            }
            for (int i=0; i<bridge.length; i++) {
                int tmp = bridge[i];
                bridge[i] = saveN;
                saveN = tmp;
            }
            sumL -= saveN;
//            System.out.println("idxN" + idxN);
//            System.out.println("trucks: " + Arrays.toString(bridge));
//            System.out.println("last " + lastTruckIdx);
            answer++;
        }
        System.out.println(answer);

    }
}