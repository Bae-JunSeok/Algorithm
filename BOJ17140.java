import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ17140 {
    static int r, c, k;
    static int[][] map;
    static int row = 3;
    static int column = 3;
    static int time = 0;
    static boolean canFind = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken()) - 1;
        c = Integer.parseInt(st.nextToken()) - 1;
        k = Integer.parseInt(st.nextToken());

        map = new int[100][100];

        for(int i = 0; i < 3; i++){
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(time <= 100){

            if(map[r][c] == k){
                canFind = true;
                break;
            }

            if(time == 100) break;

            if(row >= column){
                operationR();
            } else {
                operationC();
            }

            time++;
        }

        if(canFind){
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }

    // R 연산
    static void operationR(){
        int[][] temp = new int[100][100];
        int max = 0;

        for(int i = 0; i < row; i++){

            int[] count = new int[101];

            // 숫자의 등장 횟수 계산
            for(int j = 0; j < column; j++){
                if(map[i][j] != 0){
                    count[map[i][j]]++;
                }
            }

            ArrayList<int[]> arr = new ArrayList<>();

            // 숫자와 등장 횟수 저장
            for(int j = 1; j <= 100; j++){
                if(count[j] > 0){
                    arr.add(new int[]{j, count[j]});
                }
            }

            // 등장 횟수 기준 정렬
            // 등장 횟수가 같다면 숫자 기준 정렬
            arr.sort((a, b) -> {
                if(a[1] == b[1]){
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[1], b[1]);
            });

            // 새로운 배열에 저장
            int idx = 0;

            for(int j = 0; j < arr.size(); j++){
                if(idx >= 100) break;

                temp[i][idx] = arr.get(j)[0];
                temp[i][idx + 1] = arr.get(j)[1];

                idx += 2;
            }

            max = Math.max(max, idx);
        }

        map = temp;
        column = max;
    }

    // C 연산
    static void operationC(){
        int[][] temp = new int[100][100];
        int max = 0;

        for(int i = 0; i < column; i++){

            int[] count = new int[101];

            // 숫자의 등장 횟수 계산
            for(int j = 0; j < row; j++){
                if(map[j][i] != 0){
                    count[map[j][i]]++;
                }
            }

            ArrayList<int[]> arr = new ArrayList<>();

            // 숫자와 등장 횟수 저장
            for(int j = 1; j <= 100; j++){
                if(count[j] > 0){
                    arr.add(new int[]{j, count[j]});
                }
            }

            // 등장 횟수 기준 정렬
            // 등장 횟수가 같다면 숫자 기준 정렬
            arr.sort((a, b) -> {
                if(a[1] == b[1]){
                    return Integer.compare(a[0], b[0]);
                }

                return Integer.compare(a[1], b[1]);
            });

            // 새로운 배열에 저장
            int idx = 0;

            for(int j = 0; j < arr.size(); j++){
                if(idx >= 100) break;

                temp[idx][i] = arr.get(j)[0];
                temp[idx + 1][i] = arr.get(j)[1];

                idx += 2;
            }

            max = Math.max(max, idx);
        }

        map = temp;
        row = max;
    }
}