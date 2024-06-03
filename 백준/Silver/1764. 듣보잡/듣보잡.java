import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        TreeSet<String> list = new TreeSet<>();
        TreeSet<String> answer = new TreeSet<>();

        for (int i=0; i<n; i++) {
            list.add(br.readLine());
        }

        for (int i=0; i<m; i++) {
            String s = br.readLine();
            if (list.contains(s)) {
                answer.add(s);
            }
        }

        System.out.println(answer.size());
        for (String str : answer) {
            System.out.println(str);
        }
    }
}