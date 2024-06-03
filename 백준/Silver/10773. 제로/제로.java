import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for (int i=0; i<k; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n == 0) {
                s.pop();
            } else {
                s.add(n);
            }
        }

        int result = 0;
        int size = s.size();

        for (int i=0; i<size; i++) {
            result += s.peek();
            s.pop();
        }

        System.out.println(result);
    }
}