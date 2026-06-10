import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class JO1067 {
    static ArrayList<Integer> garo = new ArrayList<>();
    static ArrayList<Integer> sero = new ArrayList<>();
    static ArrayList<Integer> resultGaro = new ArrayList<>();
    static ArrayList<Integer> resultSero = new ArrayList<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int m, n;
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(a == 0){
                garo.add(b);
            } else {
                sero.add(b);
            }
        }
        garo.add(0);
        garo.add(n);
        sero.add(0);
        sero.add(m);
        Collections.sort(garo);
        Collections.sort(sero);
        int Max = Integer.MIN_VALUE;
        for(int i = 0; i < garo.size() - 1; i++){
            int result = Math.abs(garo.get(i) - garo.get(i + 1));
            resultGaro.add(result);
        }

        for(int i = 0; i < sero.size() - 1; i++){
            int result = Math.abs(sero.get(i) - sero.get(i + 1));
            resultSero.add(result);
        }
        for(int i = 0; i < resultGaro.size(); i++){
            for(int j = 0; j < resultSero.size(); j++){
                int result = resultGaro.get(i) * resultSero.get(j);
                if(result > Max) Max = result;
            }
        }


        System.out.println(Max);
    }
}
