import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JO1049 {
    static int n;
    static int[][] map;
    static ArrayList<int[]> candidate = new ArrayList<>();
    static int[][] result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        
        result = new int[n][n];

        

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 0) candidate.add(new int[]{i, j});
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result[i][j] = map[i][j];
            }
        }

        for(int i = 0; i < candidate.size(); i++){
            int x = candidate.get(i)[0];
            int y = candidate.get(i)[1];
            int minDist = Integer.MAX_VALUE;
            int value = 0; 
            int count = 0;
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    if(j == x && k == y) continue;
                    if(map[j][k] == 0) continue;
                    int dist = Math.abs(j - x) + Math.abs(k - y);
                    if(dist < minDist){
                        minDist = dist;
                        value = map[j][k];
                        count = 1;
                    } else if(dist == minDist){
                        count++;
                    }
                }

                if(count == 1){ 
                    result[x][y] = value;
                } else {
                    result[x][y] = 0;
                }
            }
        }



        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }


    
}
