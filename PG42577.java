import java.util.HashSet;

public class PG42577 {
    static HashSet<String> hash = new HashSet<>();
    public static void main(String[] args) {
        PG42577 sol = new PG42577();

        System.out.println(sol.solution(new String[]{"119", "97674223"}));
    }

    public boolean solution(String[] phone_book){
        for(int i = 0; i < phone_book.length; i++){
            hash.add(phone_book[i]);
        }
        boolean answer = true;
        for(int i = 0; i < phone_book.length; i++){
            for(int j = 0; j < phone_book[i].length(); j++){
                String prefix = phone_book[i].substring(0, j);
                
                if(hash.contains(prefix)){
                    return false;
                }
            }
        }

        return answer;
    }
}
