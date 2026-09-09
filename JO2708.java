import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO2708 {
    static int m, n;
    static ArrayList<edge> EdgeList = new ArrayList<>();
    static int[] parent;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        parent = new int[m];
        int sum = 0;
        make();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            sum += weight;
            EdgeList.add(new edge(from, to, weight));
        }

        EdgeList.sort((e1, e2) -> e1.weight - e2.weight);

        int count = 0;
        int result = 0;
        for(int i = 0; i < EdgeList.size(); i++){
            edge e = EdgeList.get(i);

            if(union(e.from, e.to)){
                result += e.weight;
                count++;

                if(count == m - 1) break;
            }
        }

        System.out.println(sum - result);
    }

    public static  class edge{
        int from, to, weight;

        public edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


    }

    public static void make(){
        for(int i = 0; i < m; i++){
            parent[i] = i;
        }
    }

    public static int find(int a){
        if(parent[a] == a) return a;
        return parent[a] = find(parent[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parent[aRoot] = bRoot;
        return true;
    }
}
