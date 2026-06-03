import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JO1040 {
    static int result;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s1 = st.nextToken();
        String s2 = st.nextToken();
        char[] s1ToChar = s1.toCharArray();
        char[] s2ToChar = s2.toCharArray();
        for(int i = 0; i < s1.length()/2; i++){
            char temp = s1.charAt(i);
            s1ToChar[i] = s1ToChar[s1ToChar.length - 1 -i];
            s1ToChar[s1ToChar.length - 1 -i] = temp;
        }
        s1 = new String(s1ToChar);
        for(int i = 0; i < s2.length()/2; i++){
            char temp = s2.charAt(i);
            s2ToChar[i] = s2ToChar[s2ToChar.length - 1 -i];
            s2ToChar[s2ToChar.length - 1 -i] = temp;
        }
        s2 = new String(s2ToChar);
        int shorter = 0;
        boolean firstIsShorter = true;
        if(s1.length() >= s2.length()){
            shorter = s2.length();
            firstIsShorter = false;
        } else {
            shorter = s1.length();
        }
        boolean carryOperation = false;
        for(int i = 0; i < shorter; i++){
            int a = 0;
            if(!carryOperation){
                a = (s2.charAt(i) - '0') + (s1.charAt(i) - '0');
            } else {
                a = (s2.charAt(i) - '0') + (s1.charAt(i) - '0') + 1;
            }
            if(a >= 10){
                carryOperation = true;
                result++;   
            } else {
                carryOperation = false;
            }
        }
        if(firstIsShorter){ // 첫번째것이 더 짧으면
            for(int i = shorter; i < s2.length(); i++){
                int a = 0;
                if(!carryOperation){
                    a = (s2.charAt(i) - '0');
                } else {
                    a = (s2.charAt(i) - '0') + 1;
                }
                if(a >= 10){
                    carryOperation = true;
                    result++;
                } else {
                    carryOperation = false;
                }
            }
        } else {
            for(int i = shorter; i < s1.length(); i++){
                int a = 0;
                if(!carryOperation){
                    a = (s1.charAt(i) - '0');
                } else {
                    a = (s1.charAt(i) - '0') + 1;
                }
                if(a >= 10){
                    carryOperation = true;
                    result++;
                } else {
                    carryOperation = false;
                }
            }
        }
        

        if(result == 0){
            System.out.println("No carry operation.");
        } else if(result == 1){
            System.out.println(result + " carry operation.");
        }else {
            System.out.println(result + " carry operations.");
        }
    }
}
