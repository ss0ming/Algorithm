import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] arr = new String[5];
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < 5; i++) {
            arr[i] = br.readLine();
        }

        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 5; j++) {
                if (arr[j].length() <= i) continue;
                answer.append(arr[j].charAt(i));
            }
        }

        System.out.println(answer);
    }
}