import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO3989 {
    static int n;
    static ArrayList<int[]> location = new ArrayList<>();
    static ArrayList<Edge> arr = new ArrayList<>();
    static int[] parents;

    public static class Edge implements Comparable<Edge>{
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


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n];
        make();
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            location.add(new int[]{a, b});
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i >= j) continue;
                int length = Math.abs(location.get(i)[0] - location.get(j)[0]) * Math.abs(location.get(i)[0] - location.get(j)[0]) + Math.abs(location.get(i)[1] - location.get(j)[1]) * Math.abs(location.get(i)[1] - location.get(j)[1]);
                arr.add(new Edge(i, j, length));
            }
        }

        Collections.sort(arr);
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < arr.size(); i++){
            Edge e = arr.get(i);
            if(!union(e.from, e.to)) continue;
            result = Math.max(result, e.weight);
            cnt++;
            if(cnt == n - 1) break;
        }

        System.out.println(result);
    }

    static void make(){
        for(int i = 0; i < n; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot == bRoot) return false; // 이미 연결된 상태

        parents[aRoot] = bRoot;
        return true;
    }
}
