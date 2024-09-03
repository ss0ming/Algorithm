import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String [] arr = new String[N];

        for (int i=0; i<N; i++) {
            arr[i] = br.readLine();
        }

        int k = 1;

        while(true) {
            String[] tmp = new String[N];
            for (int i=0; i<N; i++) {
                tmp[i] = arr[i].substring(arr[i].length()-k);
            }
            Arrays.sort(tmp);

            boolean flag = true;

            for (int i=1; i<N; i++) {
                if (tmp[i].equals(tmp[i-1])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                break;
            }
            k++;
        }

        System.out.println(k);
    }
}