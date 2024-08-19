import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            if (check(str.split(""))) System.out.println("YES");
            else System.out.println("NO");
        }

    }

    public static boolean check(String[] arr) {
        Stack<String> stack = new Stack<>();

        for (String cur : arr) {
            if (cur.equals("(")) stack.push(cur);
            else if (cur.equals(")")) {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }

        if (!stack.isEmpty()) return false;
        return true;
    }
}