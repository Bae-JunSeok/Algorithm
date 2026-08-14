import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class JO1350 {
    static int n, m;
    static ArrayList<edge> EdgeList = new ArrayList<>();
    static int[] parents;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        parents = new int[n + 1];
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            EdgeList.add(new edge(from, to, weight));
        }

        make();
        int result = 0;
        int cnt = 0;

        EdgeList.sort((a, b) -> Integer.compare(b.weight, a.weight));

        for(int i = 0; i < EdgeList.size(); i++){
                edge e = EdgeList.get(i);
                if(union(e.from, e.to)){
                    result += e.weight;
                    cnt++;
                }    
                if(cnt == n - 1);
            }

        System.out.println(result);
    }

    static void make(){
        for(int i = 1; i <= n; i++){
            parents[i] = i;
        }
    }

    static int find(int a){
        if(a == parents[a]) return a;
        return find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parents[aRoot] = bRoot;
        return true;
    }

    static class edge{
        int from, to, weight;

        public edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
