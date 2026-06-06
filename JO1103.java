import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1103 {
    static int n, m;
    static int store_number;
    static int[][] store_location;
    static int donggeunX, donggeunY;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        store_number = Integer.parseInt(br.readLine());
        store_location = new int[store_number][2];
        int length1 = 0, length2 = 0;
        for(int i = 0; i < store_number; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 2; j++){
                store_location[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        donggeunX = Integer.parseInt(st.nextToken());
        donggeunY = Integer.parseInt(st.nextToken());
        int result = 0;
        int total_length = 2 * n + 2 * m;
        for(int i = 0; i < store_number; i++){
            length1 = 0;
            length2 = 0;
            if(store_location[i][0] == 1){
                if(donggeunX == 1){
                    length1 = Math.abs(donggeunY - store_location[i][1]);
                    length2 = total_length - length1;
                } else if(donggeunX == 2){
                    length1 = donggeunY + m + store_location[i][1];
                    length2 = total_length - length1;
                } else if(donggeunX == 3){
                    length1 = store_location[i][1] + donggeunY;
                    length2 = total_length - length1;
                } else {
                    length1 = donggeunY + (n - store_location[i][1]);
                    length2 = total_length - length1;
                }
            } else if(store_location[i][0] == 2){
                if(donggeunX == 1){
                    length1 = donggeunY + m + store_location[i][1];
                    length2 = total_length - length1;
                } else if(donggeunX == 2){
                    length1 = Math.abs(donggeunY - store_location[i][1]);
                    length2 = total_length - length1;
                } else if(donggeunX == 3){
                    length1 = (m - donggeunY) + store_location[i][1];
                    length2 = total_length - length1;
                } else {
                    length1 = donggeunY + (n - store_location[i][1]);
                    length2 = total_length - length1;
                }
            } else if(store_location[i][0] == 3){
                if(donggeunX == 1){
                    length1 = donggeunY + store_location[i][1];
                    length2 = total_length - length1;
                } else if(donggeunX == 2){
                    length1 = m - store_location[i][1] + donggeunY;
                    length2 = total_length - length1;
                } else if(donggeunX == 3){
                    length1 = Math.abs(donggeunY - store_location[i][1]);
                    length2 = total_length - length1;
                } else {
                    length1 = n + donggeunY + store_location[i][1];
                    length2 = total_length - length1;
                }
            } else {
                if(donggeunX == 1){
                    length1 = m - donggeunY + store_location[i][1];
                    length2 = total_length - length1;
                } else if(donggeunX == 2){
                    length1 = m - donggeunY + n - store_location[i][1];
                    length2 = total_length - length1;
                } else if(donggeunX == 3){
                    length1 = n + store_location[i][1] + donggeunY;
                    length2 = total_length - length1;
                } else {
                    length1 = Math.abs(donggeunY - store_location[i][1]);
                    length2 = total_length - length1;
                }
            }
            if(length1 >= length2){
                result += length2;
            } else {
                result += length1;
            }
        }
        System.out.println(result);
    }
}
