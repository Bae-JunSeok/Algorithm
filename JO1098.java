import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO1098 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        int zero = 6;
        int one = 2;
        int two = 5;
        int three = 5;
        int four = 4;
        int five = 5;
        int six = 6;
        int seven = 3;
        int eight = 7;
        int nine = 6;

        int result = 0;

        for(int i = 0; i < s.length(); i++){
            int target = s.charAt(i) - '0';
            if(target == 0){
                result += zero;
            } else if(target == 1){
                result += one;
            } else if(target == 2){
                result += two;
            } else if(target == 3){
                result += three;
            } else if(target == 4){
                result += four;
            } else if(target == 5){
                result += five;
            } else if(target == 6){
                result += six;
            } else if(target == 7){
                result += seven;
            } else if(target == 8){
                result += eight;
            } else if(target == 9){
                result += nine;
            }
        }

        System.out.println(result);
    }
}
