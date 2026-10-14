import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO26276 {
    static int n, m;
    static int[] parents;
    static int start, target = 0;
    static ArrayList<Edge> arr = new ArrayList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parents = new int[n + 1];
        make();
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            arr.add(new Edge(from, to, weight));
            arr.add(new Edge(to, from, weight));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        target = Integer.parseInt(st.nextToken());

        arr.sort((a, b) -> b.weight - a.weight);

        for(int i = 0; i < arr.size(); i++){
            Edge e = arr.get(i);
            if(union(e.from, e.to)){
                if(find(start) == find(target)){
                    min = e.weight;
                    break;
                }
            }
        }

        System.out.println(min);
    }

    static void make(){
        for(int i = 0; i <= n; i++){
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

    static class Edge{
        int from, to, weight;

        public Edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
