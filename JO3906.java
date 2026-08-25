import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class JO3906 {
    static char[][] map;
    static int n, m;
    static ArrayList<int[]> result = new ArrayList<>();
    static boolean[][] added;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        added = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String input = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = input.charAt(j);
            }
        }


        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.'){ // 가로 체크
                    if(j - 1 < 0 || map[i][j - 1] == '#'){ 
                        if(j + 2 < m){
                            if(map[i][j + 1] == '.' && map[i][j + 2] == '.'){
                                if(!added[i][j]){
                                    result.add(new int[]{i + 1, j + 1});
                                    added[i][j] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == '.'){
                    if(i - 1 < 0 || map[i - 1][j] == '#'){ // 왼쪽 칸이 격자 밖이거나 막혀있을 때
                        if(i + 2 < n){
                            if(map[i + 1][j] == '.' && map[i + 2][j] == '.'){
                                if(!added[i][j]){
                                    result.add(new int[]{i + 1, j + 1});
                                    added[i][j] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        result.sort((a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        

        System.out.println(result.size());
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i)[0] + " " + result.get(i)[1]);
        }
    }
}
