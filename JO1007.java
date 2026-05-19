import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1007 {
    // 일단 날짜가 없는 날짜이면 에러를 출력하도록
    // 날짜를 다 더한 다음에 나누는 방향으로 해야하지 않나??????
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            st = new StringTokenizer(br.readLine());
            if(st == null) break;
            int year = 0;
            int month = 0;
            int day = 0;
            for(int i = 2000; i < year; i++){
                for(int j = 1; j < month; j++){

                }
            }
        }

        System.out.println(sb);
    }
}
