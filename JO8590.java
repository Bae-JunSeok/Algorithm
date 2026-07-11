import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class JO8590 {
    static int x = 0;
    static int y = 0;

    static HashSet<String> roads = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int d = Integer.parseInt(br.readLine());

        for (int i = 0; i < d; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String direction = st.nextToken();
            int distance = Integer.parseInt(st.nextToken());

            if (direction.equals("N")) {
                // y가 고정된 세로 도로
                roads.add("V," + y);
                x -= distance;

            } else if (direction.equals("S")) {
                // y가 고정된 세로 도로
                roads.add("V," + y);
                x += distance;

            } else if (direction.equals("E")) {
                // x가 고정된 가로 도로
                roads.add("H," + x);
                y += distance;

            } else if (direction.equals("W")) {
                // x가 고정된 가로 도로
                roads.add("H," + x);
                y -= distance;
            }
        }

        System.out.println(roads.size());
    }
}