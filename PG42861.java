import java.util.ArrayList;

public class PG42861 {
    static int[] parent;
    static ArrayList<edge> edgeList = new ArrayList<>();
    public static void main(String[] args) {
        PG42861 sol = new PG42861();

        System.out.println(sol.solution(4, new int[][]{{0, 1, 1}, {0, 2, 2}, {1, 2, 5}, {1, 3, 1}, {2, 3, 8}}));
    }

    public int solution(int n, int[][] costs){
        int answer = 0;
        parent = new int[n];

        for(int i = 0; i < costs.length; i++){
            int from = costs[i][0];
            int to = costs[i][1];
            int weight = costs[i][2];

            edgeList.add(new edge(from, to, weight));
        }
        make(n);
        edgeList.sort((e1, e2) -> e1.weight - e2.weight);

        int count = 0;

        for(int i = 0; i < edgeList.size(); i++){
            edge e = edgeList.get(i);
            if(union(e.from, e.to)){
                answer += e.weight;
                count++;
            }

            if(count == n - 1) break;
        }

        return answer;
    }

    static class edge{
        int from, to, weight;

        public edge(int from, int to, int weight){
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    static void make(int n){
        for(int i = 0; i < n; i++){
            parent[i] = i;
        }
    }

    static int find(int a){
        if(a == parent[a]) return a;
        return parent[a] = find(parent[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);

        if(aRoot == bRoot) return false;
        parent[aRoot] = bRoot;
        return true;
    }
}
