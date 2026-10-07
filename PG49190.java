import java.util.HashSet;
import java.util.Set;

public class PG49190 {

    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static Set<Point> visitedVertex = new HashSet<>();
    static Set<Edge> visitedEdge = new HashSet<>();

    public static void main(String[] args) {
        PG49190 sol = new PG49190();

        System.out.println(
                sol.solution(
                        new int[]{6, 6, 6, 4, 4, 4, 2, 2, 2,
                                0, 0, 0, 1, 6, 5, 5, 3, 6, 0}
                )
        );
    }

    public int solution(int[] arrows) {
        int answer = 0;

        // solution이 여러 번 호출될 수도 있으므로 초기화
        visitedVertex.clear();
        visitedEdge.clear();

        int x = 0;
        int y = 0;

        // 시작점 방문
        visitedVertex.add(new Point(0, 0));

        for (int dir = 0; dir < arrows.length; dir++) {

            int d = arrows[dir];

            // 대각선 교차점 처리를 위해 한 이동을 2번으로 나눔
            for (int i = 0; i < 2; i++) {

                int nx = x + dx[d];
                int ny = y + dy[d];

                Point next = new Point(nx, ny);
                Edge edge = new Edge(x, y, nx, ny);

                // 이미 방문한 정점인데
                // 현재 간선은 처음 지나가는 경우
                // → 새로운 방 생성
                if (visitedVertex.contains(next)
                        && !visitedEdge.contains(edge)) {
                    answer++;
                }

                // 정점 방문 처리
                visitedVertex.add(next);

                // 간선 방문 처리
                // 양방향 모두 저장
                visitedEdge.add(new Edge(x, y, nx, ny));
                visitedEdge.add(new Edge(nx, ny, x, y));

                x = nx;
                y = ny;
            }
        }

        return answer;
    }

    public class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Point)) return false;

            Point p = (Point) o;

            return x == p.x && y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }

    public class Edge {
        int fromX, fromY;
        int toX, toY;

        public Edge(int fromX, int fromY, int toX, int toY) {
            this.fromX = fromX;
            this.fromY = fromY;
            this.toX = toX;
            this.toY = toY;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Edge)) return false;

            Edge e = (Edge) o;

            return fromX == e.fromX
                    && fromY == e.fromY
                    && toX == e.toX
                    && toY == e.toY;
        }

        @Override
        public int hashCode() {
            int result = fromX;
            result = 31 * result + fromY;
            result = 31 * result + toX;
            result = 31 * result + toY;

            return result;
        }
    }
}