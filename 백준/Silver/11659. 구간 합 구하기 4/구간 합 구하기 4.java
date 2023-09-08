import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N+1];
        int sum = 0;

        for (int i=1; i<N+1; i++) {
            sum += sc.nextInt();
            arr[i] = sum;
        }

        for (int i=0; i<M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();

            int result = arr[to] - arr[from-1];

            System.out.println(result);
        }
    }
}