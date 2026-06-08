import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class JO3118 {
    static int n, m;
    static int[] head;
    static int[] to;
    static int[] cost;
    static int[] next;
    static int edgeIndex = 0;

    static long[] dist;

    static class Node implements Comparable<Node> {
        int vertex;
        long distance;

        Node(int vertex, long distance) {
            this.vertex = vertex;
            this.distance = distance;
        }

        @Override
        public int compareTo(Node other) {
            return Long.compare(this.distance, other.distance);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        head = new int[n + 1];
        to = new int[m];
        cost = new int[m];
        next = new int[m];

        Arrays.fill(head, -1);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            addEdge(a, b, c);
        }

        dijkstra(1);

        System.out.println(dist[n]);
    }

    static void addEdge(int from, int destination, int weight) {
        to[edgeIndex] = destination;
        cost[edgeIndex] = weight;
        next[edgeIndex] = head[from];
        head[from] = edgeIndex;
        edgeIndex++;
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist = new long[n + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        dist[start] = 0;
        pq.add(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            int curVertex = current.vertex;
            long curDistance = current.distance;

            if (dist[curVertex] < curDistance) {
                continue;
            }

            for (int edge = head[curVertex]; edge != -1; edge = next[edge]) {
                int nextVertex = to[edge];
                long nextDistance = curDistance + cost[edge];

                if (dist[nextVertex] > nextDistance) {
                    dist[nextVertex] = nextDistance;
                    pq.add(new Node(nextVertex, nextDistance));
                }
            }
        }
    }
}