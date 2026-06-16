import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO4575 {
    static int[][] map = new int[8][8];
    static int[][] result = new int[8][8];
    static int[] dx = new int[]{-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = new int[]{0, -1, 0, 1, 1, -1, 1, -1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int i = 0; i < 8; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 8; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        simul();

        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
    
    static void simul(){
    for(int i = 0; i < 8; i++){
        for(int j = 0; j < 8; j++){
            if(map[i][j] == 0){
                for(int dir = 0; dir < 8; dir++){
                    boolean hasWhite = false;

                    for(int k = 1; k < 8; k++){
                        int nx = i + k * dx[dir];
                        int ny = j + k * dy[dir];

                        if(nx < 0 || nx >= 8 || ny < 0 || ny >= 8) break;

                        if(map[nx][ny] == 0){
                            break;
                        }

                        if(map[nx][ny] == 2){
                            hasWhite = true;
                        } 
                        else if(map[nx][ny] == 1){
                            if(hasWhite){
                                result[i][j] = 1;
                            }
                            break;
                        }
                    }
                }
            }
        }
    }
}
}
