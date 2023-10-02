import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] parent = new int[n];
		for (int i = 0; i < n-1; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			parent[c] = p;
		}
		parent[0] = -1;
		int[] arr = new int[n];
		st = new StringTokenizer(br.readLine());
		int target = 0;
		for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] == k) {
				target = i;
			}
		}
		System.out.println(depthToRoot(target,0,parent));
		
	}
	public static int depthToRoot(int x, int depth, int[] parent) {
		if(parent[x] == -1) return depth;
		return depthToRoot(parent[x],depth+1,parent);
		
	}
}