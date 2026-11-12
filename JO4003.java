
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class JO4003 {
    static int n;
    static char[][] map;
    static boolean[][] isVisited;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(
            new InputStreamReader(System.in)
        );

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        System.out.println(bfs());
    }

    // 위치와 방향을 하나의 숫자로 변환
    static int encode(int x, int y, int dir) {
        return (x * n + y) * 4 + dir;
    }

    static int bfs() {
        int total = n * n * 4;
        isVisited = new boolean[total][total];

        Queue<int[]> q = new LinkedList<>();

        // 첫 번째: 위쪽 시작
        // 두 번째: 오른쪽 시작
        q.add(new int[]{
            n - 1, 0, 0,
            n - 1, 0, 1,
            0
        });

        int start1 = encode(n - 1, 0, 0);
        int start2 = encode(n - 1, 0, 1);

        isVisited[start1][start2] = true;

        while (!q.isEmpty()) {
            int[] node = q.poll();

            int x1 = node[0];
            int y1 = node[1];
            int dir1 = node[2];

            int x2 = node[3];
            int y2 = node[4];
            int dir2 = node[5];

            int dist = node[6];

            // 둘 다 도착한 경우
            if (x1 == 0 && y1 == n - 1 &&
                x2 == 0 && y2 == n - 1) {
                return dist;
            }

            // 0: 전진, 1: 오른쪽 회전, 2: 왼쪽 회전
            for (int command = 0; command < 3; command++) {

                int nx1 = x1;
                int ny1 = y1;
                int nd1 = dir1;

                int nx2 = x2;
                int ny2 = y2;
                int nd2 = dir2;

                if (command == 0) {
                    // 첫 번째 Bessie 이동
                    if (!(x1 == 0 && y1 == n - 1)) {
                        int tx = x1 + dx[dir1];
                        int ty = y1 + dy[dir1];

                        if (tx >= 0 && tx < n &&
                            ty >= 0 && ty < n &&
                            map[tx][ty] != 'H') {
                            nx1 = tx;
                            ny1 = ty;
                        }
                    }

                    // 두 번째 Bessie 이동
                    if (!(x2 == 0 && y2 == n - 1)) {
                        int tx = x2 + dx[dir2];
                        int ty = y2 + dy[dir2];

                        if (tx >= 0 && tx < n &&
                            ty >= 0 && ty < n &&
                            map[tx][ty] != 'H') {
                            nx2 = tx;
                            ny2 = ty;
                        }
                    }

                } else if (command == 1) {
                    // 오른쪽 90도 회전
                    if (!(x1 == 0 && y1 == n - 1)) {
                        nd1 = (dir1 + 1) % 4;
                    }

                    if (!(x2 == 0 && y2 == n - 1)) {
                        nd2 = (dir2 + 1) % 4;
                    }

                } else {
                    // 왼쪽 90도 회전
                    if (!(x1 == 0 && y1 == n - 1)) {
                        nd1 = (dir1 + 3) % 4;
                    }

                    if (!(x2 == 0 && y2 == n - 1)) {
                        nd2 = (dir2 + 3) % 4;
                    }
                }

                int state1 = encode(nx1, ny1, nd1);
                int state2 = encode(nx2, ny2, nd2);

                if (isVisited[state1][state2]) {
                    continue;
                }

                isVisited[state1][state2] = true;

                q.add(new int[]{
                    nx1, ny1, nd1,
                    nx2, ny2, nd2,
                    dist + 1
                });
            }
        }

        return -1;
    }
}
