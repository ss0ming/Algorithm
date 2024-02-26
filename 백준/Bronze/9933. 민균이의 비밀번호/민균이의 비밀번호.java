import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<String> list = new LinkedList<>();
        List<String> revList = new LinkedList<>();

        int n = Integer.parseInt(br.readLine());

        for (int i=0; i<n; i++) {
            String s = br.readLine();
            list.add(s);

            StringBuilder sb = new StringBuilder(s);
            revList.add(sb.reverse().toString());
        }

        for (int i=0; i<n; i++) {
            if (revList.contains(list.get(i))) {
                String s = list.get(i);
                System.out.println(s.length() + " " + s.charAt(s.length()/2));
                return;
            }
        }
    }
}
