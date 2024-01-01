import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sum = 0;
        int odd = -1;

        for (int i = 0; i < 7; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num % 2 == 1) {
                sum += num;
                if (odd == -1) odd = num;
                else if (odd > num) odd = num;
            }
        }

        if (odd == -1) {
            System.out.println(odd);
            return;
        }

        System.out.println(sum);
        System.out.println(odd);
    }
}