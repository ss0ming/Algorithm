import java.io.*;
import java.util.*;

public class Main {

    static int l;
    static Character[] arr;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        l = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        arr = new Character[c];
        boolean[] visited = new boolean[c];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr);

        dfs(0, visited, 0);



    }

    public static void dfs(int cur, boolean[] visited, int cnt) {
        if (cnt == l) {
            print(visited);
        }

        for (int i=cur; i<arr.length; i++) {
            visited[i] = true;
            dfs(i+1, visited, cnt+1);
            visited[i] = false;
        }
    }

    public static void print(boolean[] visited) {
        int ja = 0;
        int mo = 0;
        StringBuilder s = new StringBuilder();
        for (int i=0; i<arr.length; i++) {
            if (!visited[i]) continue;

            if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u') {
                mo++;
            } else {
                ja++;
            }

            s.append(arr[i]);
        }

        if (mo >= 1 && ja >= 2) {
            System.out.println(s);
        }
    }
}