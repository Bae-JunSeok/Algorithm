import java.io.BufferedReader;
import java.io.InputStreamReader;

public class 문자열찾기 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int resultKOI = 0;
        int resultIOI = 0;
        for(int i = 0; i < s.length() - 2; i++){
            if(s.charAt(i) == 'K' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') resultKOI++;
            if(s.charAt(i) == 'I' && s.charAt(i + 1) == 'O' && s.charAt(i + 2) == 'I') resultIOI++;
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append(resultKOI).append("\n").append(resultIOI);
        System.out.println(sb);
    }
}
