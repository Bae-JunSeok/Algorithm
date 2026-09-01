import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1182 {
    static int H, F;
    static boolean[] isVisited;
    static ArrayList<int[]> arr = new ArrayList<>();
    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());

        Queue<int[]> q = new LinkedList<>();
        isVisited = new boolean[F];

        for(int i = 0; i < F; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            arr.add(new int[]{x, y});
            if(y <= 1000){
                q.add(new int[]{x, y, 1});
                isVisited[i] = true;
            }
        }

        int result = 0;

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int curX = node[0];
            int curY = node[1];
            int curCount = node[2];
            if(H - curY <= 1000){ // 만약에 지금 현재 위치가 저러면은 바로 탈출
                result = curCount;
                break;
            }
            for(int i = 0; i < F; i++){
                if(curX == arr.get(i)[0] && curY == arr.get(i)[1]) continue;
                if(isVisited[i]) continue;

                int nextX = arr.get(i)[0];
                int nextY = arr.get(i)[1];

                if (Math.sqrt(Math.pow(curX - nextX, 2) +Math.pow(curY - nextY, 2)) <= 1000){
                    q.add(new int[]{arr.get(i)[0], arr.get(i)[1], curCount + 1});
                    isVisited[i] = true;
                }
            }
        }
        System.out.println(result);
    }
}
