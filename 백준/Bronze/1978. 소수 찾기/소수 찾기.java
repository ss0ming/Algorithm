import java.io.*;
import java.util.*;

public class Main {

    static int ans = 0;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i=0; i<N; i++) {
            int n = Integer.parseInt(st.nextToken());
            if (isPrime(n)) ans++;
        }

        System.out.println(ans);
    }

    public static boolean isPrime(int n) {
        if (n == 1) return false;
        for (int i=2; i<=Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }

        return true;
    }
}