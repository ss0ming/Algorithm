import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int x = 0;
        int y = 0;
        int totalArea = 0;
        boolean[][] paper = new boolean[100][100];

        for (int i = 0; i < N; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
            x = Integer.parseInt(stringTokenizer.nextToken());
            y = Integer.parseInt(stringTokenizer.nextToken());
            for (int j = x; j < x + 10; j++) {
                for (int k = y; k < y + 10; k++) {
                    if (!paper[j][k]) {
                        paper[j][k] = true;
                        totalArea++;
                    }
                }

            }
        }
        System.out.println(totalArea);
    }
}