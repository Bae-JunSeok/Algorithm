import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PG1844 {
    public static void main(String[] args) {
        PG1844 sol = new PG1844();

        System.out.println(sol.solution(new int[][]{
            {1,0,1,1,1},
            {1,0,1,0,1},
            {1,0,1,1,1},
            {1,1,1,0,1},
            {0,0,0,0,1}
        }));
    }

    public int solution(int[][] maps){
        int[] dx = new int[]{-1, 0, 1, 0};
        int[] dy = new int[]{0, -1, 0, 1};
        int[][] dist = new int[maps.length][maps[0].length];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < maps.length; i++){
            Arrays.fill(dist[i], -1);
        }

        q.add(new int[]{0, 0});
        dist[0][0] = 1;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            for(int dir = 0; dir < 4; dir++){
                int nx = curX + dx[dir];
                int ny = curY + dy[dir];
                if(nx < 0 || nx >= maps.length || ny < 0 || ny >= maps[0].length) continue;
                if(maps[nx][ny] == 0 || dist[nx][ny] != -1) continue;
                q.add(new int[]{nx, ny});
                dist[nx][ny] = dist[curX][curY] + 1;
            }
        }

        if(dist[maps.length - 1][maps[0].length - 1] != -1){
            return dist[maps.length - 1][maps[0].length - 1];
        } else {
            return -1;
        }
    }
}
