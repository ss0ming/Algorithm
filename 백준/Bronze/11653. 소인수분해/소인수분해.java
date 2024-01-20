import java.io.*;
import java.util.*;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        if (N == 1) return;

        int i = 2;

        while (N != 1) {
            if (N % i != 0) {
                i++;
                continue;
            }

            N /= i;
            System.out.println(i);
        }
    }
}