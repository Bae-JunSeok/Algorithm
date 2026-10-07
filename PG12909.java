import java.util.Stack;

public class PG12909 {
    public static void main(String[] args) {
        PG12909 sol = new PG12909();
        System.out.println(sol.solution("))))"));
    }

    boolean solution(String s){
        boolean answer = true;

        Stack<Character> stck = new Stack<>();

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stck.add(c);
            } else if(c == ')') {
                if(stck.isEmpty()){
                    answer = false;
                    break;
                } else {
                    stck.pop();
                }
            }
        }

        if(!stck.isEmpty()){
            answer = false;
        }

        return answer;
    }
}
