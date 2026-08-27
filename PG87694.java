import java.util.LinkedList;
import java.util.Queue;

public class PG87694 {
    public static void main(String[] args) {
        PG87694 sol = new PG87694();

        System.out.println(sol.solution(
                new int[][]{
                        {1, 1, 7, 4},
                        {3, 2, 5, 5},
                        {4, 3, 6, 9},
                        {2, 6, 8, 8}
                },
                1, 3, 7, 8
        ));
    }

    public int solution(int[][] rectangle,
                        int characterX,
                        int characterY,
                        int itemX,
                        int itemY) {

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};

        // 좌표가 최대 50이고 2배하므로 100 이상 필요
        int[][] map = new int[102][102];
        boolean[][] isVisited = new boolean[102][102];

        // 1. 사각형 전체 영역을 1로 채우기
        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int x = x1; x <= x2; x++) {
                for (int y = y1; y <= y2; y++) {
                    map[x][y] = 1;
                }
            }
        }

        // 2. 사각형 내부를 0으로 만들기
        // 결국 테두리만 1로 남게 됨
        for (int i = 0; i < rectangle.length; i++) {

            int x1 = rectangle[i][0] * 2;
            int y1 = rectangle[i][1] * 2;
            int x2 = rectangle[i][2] * 2;
            int y2 = rectangle[i][3] * 2;

            for (int x = x1 + 1; x < x2; x++) {
                for (int y = y1 + 1; y < y2; y++) {
                    map[x][y] = 0;
                }
            }
        }

        // 3. 시작점도 2배
        int startX = characterX * 2;
        int startY = characterY * 2;

        // 4. 도착점도 2배
        int targetX = itemX * 2;
        int targetY = itemY * 2;

        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{startX, startY, 0});
        isVisited[startX][startY] = true;

        // 5. BFS
        while (!q.isEmpty()) {

            int[] node = q.poll();

            int curX = node[0];
            int curY = node[1];
            int curDist = node[2];

            if (curX == targetX && curY == targetY) {
                // 좌표를 2배했기 때문에 거리도 2배
                return curDist / 2;
            }

            for (int dir = 0; dir < 4; dir++) {

                int nx = curX + dx[dir];
                int ny = curY + dy[dir];

                if (nx < 0 || nx >= 102 || ny < 0 || ny >= 102) {
                    continue;
                }

                if (isVisited[nx][ny]) {
                    continue;
                }

                // 테두리가 아닌 곳은 이동 불가
                if (map[nx][ny] == 0) {
                    continue;
                }

                q.add(new int[]{nx, ny, curDist + 1});
                isVisited[nx][ny] = true;
            }
        }

        return -1;
    }
}