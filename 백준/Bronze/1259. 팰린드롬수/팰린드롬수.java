import java.io.BufferedReader;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String str = br.readLine();
            if (str.equals("0")) {
                break;
            }

            String reverseStr = new StringBuilder(str).reverse().toString();
            if (str.equals(reverseStr)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}