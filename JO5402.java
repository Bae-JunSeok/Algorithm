import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO5402 {
    static int n;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int[] parents;
    static int[][] map;
    static ArrayList<Edge> edgeList = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        parents = new int[n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.add(new int[]{a, b});
        }
        for(int i = 0; i < n; i++){
            int dist = 0;
            for(int j = 0; j < n; j++){
                dist = (Math.abs(arr.get(i)[0]) - Math.abs(arr.get(j)[0])) * (Math.abs(arr.get(i)[0]) - Math.abs(arr.get(j)[0])) + (Math.abs(arr.get(i)[1]) - Math.abs(arr.get(j)[1])) * (Math.abs(arr.get(i)[1]) - Math.abs(arr.get(j)[1]));
                map[i][j] = dist;   
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i >= j) continue;
                edgeList.add(new Edge(i, j, map[i][j]));
            }
        }

        make();
        Collections.sort(edgeList);
        int result = 0;
        int cnt = 0;
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i < edgeList.size(); i++){
            Edge e = edgeList.get(i);
            if(!union(e.from, e.to)) continue; // 만약에 e.from이랑 e.to가 union이 안되면 즉 이미 합쳐져 있다면
            result += e.weight;
            if(e.weight > Max) Max = e.weight;
            cnt++;
            if(cnt == n - 1) break;
        }

        System.out.println(Max);
    }

    static void make(){
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(parents[a] == a) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false;

        parents[aRoot] = bRoot;
        return true;
    }

    static class Edge implements Comparable<Edge>{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            super();
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o){
            return Integer.compare(this.weight, o.weight);
        }
    }
}
