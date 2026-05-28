import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1031 {
    static int[][] map = new int[5][5];
    static int result = 0;
    //static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    //static int[] dy = new int[]{0, -1, 0, 1, -1, 1, -1, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        outer:
        for(int i = 0; i < 5; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++){
                int target = Integer.parseInt(st.nextToken());
                boolean bingo = false;
                for(int k = 0; k < 5; k++){
                    for(int p = 0; p < 5; p++){
                        if(map[k][p] == target){
                            map[k][p] = 0;
                        }
                    }
                }
                bingo = simulation();
                result++;
                if (bingo) {
                    break outer;
                }
            }
        }
        System.out.println(result);
    }

    static boolean simulation(){
        int count = 0;
        for(int i = 0; i < 5; i++){ // 가로
            int c = 0;
            for(int j = 0; j < 5; j++){
                if(map[i][j] == 0) c++;
            }
            if(c == 5){
                count++;
            }
        }

        for(int i = 0; i < 5; i++){ // 세로
            int c = 0;
            for(int j = 0; j < 5; j++){
                if(map[j][i] == 0) c++;
            }
            if(c == 5){
                count++;
            }
        }
        // 대각
        if(map[0][0] == 0 && map[1][1] == 0 && map[2][2] == 0 && map[3][3] == 0 && map[4][4] == 0) count++;
        if(map[0][4] == 0 && map[1][3] == 0 && map[2][2] == 0 && map[3][1] == 0 && map[4][0] == 0) count++;

        if(count >= 3){
            return true;
        } else {
            return false;
        }

    }
}
