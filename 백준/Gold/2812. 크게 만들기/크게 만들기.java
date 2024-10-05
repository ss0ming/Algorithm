import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        String num = br.readLine();
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        int count = 0;

        for (int i=0; i<N; i++) {
            while (!stack.isEmpty() && count < K && stack.peek() < num.charAt(i)) {
                stack.pop();
                count++;
            }

            if (stack.size() < N-K) {
                stack.add(num.charAt(i));
            }
        }

        for (int i=0; i<stack.size(); i++) {
            sb.append(stack.get(i));
        }

        System.out.println(sb);

    }
}