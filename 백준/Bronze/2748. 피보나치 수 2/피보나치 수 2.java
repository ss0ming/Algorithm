import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Long[] fib = new Long[N+1];
        fib[0] = (long)0;
        fib[1] = (long)1;

        for (int i=2; i<N+1; i++) {
            fib[i] = fib[i-2] + fib[i-1];
        }

        System.out.println(fib[N]);
    }
}