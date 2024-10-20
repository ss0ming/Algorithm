import java.util.*;
import java.io.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int end, weight, dir;
        public Edge(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }
        public Edge(int end, int weight, int dir) {
            this.end = end;
            this.weight = weight;
            this.dir = dir;
        }
        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.weight, o.weight);
        }
    }
    static int N, M;
    static List<Edge>[] graph;
    static int[] disFox;
    static int[][] disWolf;
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N];
        for(int i =0 ; i < N ; i++){
            graph[i] = new ArrayList<>();
        }

        disFox = new int[N];
        disWolf = new int[2][N];

        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            int dis = Integer.parseInt(st.nextToken());

            graph[to].add(new Edge(from, dis*2));
            graph[from].add(new Edge(to, dis*2));
        }

        Arrays.fill(disFox, Integer.MAX_VALUE);
        Arrays.fill(disWolf[0], Integer.MAX_VALUE);
        Arrays.fill(disWolf[1], Integer.MAX_VALUE);

        findFoxPath();
        findWolfPath();

        int cnt = 0;
        for(int i =0 ; i < N ; i++){
            if(disFox[i] < Integer.min(disWolf[0][i], disWolf[1][i])) cnt++;
        }
        System.out.println(cnt);
    }


    private static void findWolfPath() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0, 0));

        disWolf[0][0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(disWolf[cur.dir][cur.end] < cur.weight) continue; 

            for(Edge nEdge : graph[cur.end]){
                int nNode = nEdge.end;
                int nWeight = cur.weight;
                int nDir = 0;

                if(cur.dir == 0){  
                    nWeight += nEdge.weight / 2;
                    nDir = 1;
                } else{
                    nWeight += nEdge.weight * 2;
                    nDir = 0;
                }

                if(disWolf[nDir][nNode] > nWeight){
                    disWolf[nDir][nNode] = nWeight;
                    pq.add(new Edge(nNode, nWeight, nDir));
                }
            }
        }
    }

    private static void findFoxPath() {
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(0, 0));

        disFox[0] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();

            if(disFox[cur.end] < cur.weight) continue;

            for(Edge nEdge : graph[cur.end]){
                int nNode = nEdge.end;
                int nWeight = cur.weight + nEdge.weight;

                if(disFox[nNode] > nWeight){
                    disFox[nNode] = nWeight;
                    pq.add(new Edge(nNode, nWeight));
                }
            }
        }
    }
}