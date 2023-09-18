import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int[] arr = new int[10];

        for (int i=0; i<s.length(); i++) {
            arr[s.charAt(i) - '0'] += 1;
        }

        int nums = 0;

        for (int i=0; i<arr.length; i++) {
            if (i == 6 || i == 9) {
                continue;
            }
            if (arr[i] > nums) {
                nums = arr[i];
            }
        }

        int sum = arr[6] + arr[9];

        if (sum%2 == 0) {
            sum /= 2;
        } else {
            sum = sum/2 + 1;
        }

        if (sum > nums) {
            nums = sum;
        }

        System.out.println(nums);

    }
}