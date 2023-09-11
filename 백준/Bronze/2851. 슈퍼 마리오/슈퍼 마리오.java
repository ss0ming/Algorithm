import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        int answer = 100;
        int k = 100;

        for (int i = 0; i < 10; i++) {
            sum += Integer.parseInt(br.readLine());
            if (Math.abs(100-sum) <= k) {
                k = Math.abs(100-sum);
                answer = sum;
            }
        }
        System.out.println(answer);
    }
}