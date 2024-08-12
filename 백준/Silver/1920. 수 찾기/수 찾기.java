import java.io.*;
import java.util.*;

public class Main {

    static List<Integer> list;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String l = br.readLine();
        String[] str = l.split(" ");
        list = new ArrayList<>();
        for (int i=0; i<N; i++) {
            list.add(Integer.parseInt(str[i]));
        }

        Collections.sort(list);

        int M = Integer.parseInt(br.readLine());
        String l2 = br.readLine();
        String[] str2 = l2.split(" ");
        for (int i=0; i<M; i++) {
            int n = Integer.parseInt(str2[i]);
            if (checkArr(n)) {
                System.out.println("1");
            } else {
                System.out.println("0");
            }
        }

    }

    public static boolean checkArr(int n) {
        int l = 0;
        int r = list.size() - 1;
        int m = (l + r) / 2;

        while (l <= r) {
            if (list.get(m) == n) {
                return true;
            } else if (list.get(m) < n) {
                l = m + 1;
                m = (l + r) / 2;
            } else if (list.get(m) > n) {
                r = m - 1;
                m = (l + r) / 2;
            }
        }

        return false;
    }
}