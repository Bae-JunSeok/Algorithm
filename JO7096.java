
import java.io.*;
import java.util.*;

public class JO7096 {
    static ArrayList<Integer>[] arr = new ArrayList[101];
    static boolean[] isVisited = new boolean[101];
    static int[] parent = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        int k = Integer.parseInt(br.readLine());

        for (int i = 1; i <= 100; i++) {
            arr[i] = new ArrayList<>();
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == -1) break;

            int n = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                int b = Integer.parseInt(st.nextToken());
                arr[b].add(a);
            }
        }

        bfs(k);
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        isVisited[start] = true;

        while (!q.isEmpty()) {
            int now = q.poll();

            // 더 아래로 갈 수 없다면 루트
            if (arr[now].isEmpty()) {
                printPath(start, now);
                return;
            }

            for (int next : arr[now]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    parent[next] = now;
                    q.offer(next);
                }
            }
        }
    }

    static void printPath(int start, int end) {
        ArrayList<Integer> path = new ArrayList<>();

        int now = end;

        while (now != start) {
            path.add(now);
            now = parent[now];
        }

        path.add(start);
        Collections.reverse(path);

        for (int node : path) {
            System.out.print(node + " ");
        }
    }
}
