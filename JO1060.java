import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JO1060 {
    static int n;
    static int[] parents;
    static Edge[] edgeList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        parents = new int[n];
        edgeList = new Edge[n * (n - 1) / 2];
        int a = 0;
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                int weight = Integer.parseInt(st.nextToken());
                if(i >= j) continue;
                edgeList[a] = new Edge(i, j, weight);
                a++;
            }
        }

        Arrays.sort(edgeList);
        make();
        int result = 0;
        int cnt = 0;
        for(int i = 0; i < edgeList.length; i++){
            Edge e = edgeList[i];
            if(!union(e.from, e.to)) continue;
            result += e.weight;
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
        if(aRoot == bRoot) return false;

        parents[bRoot] = aRoot;
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
