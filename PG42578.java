import java.util.HashMap;
import java.util.Map;

public class PG42578 {
    static HashMap<String, Integer> hash = new HashMap<>();
    public static void main(String[] args) {
        PG42578 sol = new PG42578();
        String[][] clothes = {
            {"hello", "hi"},
            {"haha", "hoho"}
        };
        System.out.println(sol.solution(clothes));
    }

    public int solution(String[][] clothes){
        int result = 1;
        for(int i = 0; i < clothes.length; i++){
            hash.put(clothes[i][1], hash.getOrDefault(clothes[i][1], 0) + 1);
            
        }

        for(Map.Entry<String, Integer> entry: hash.entrySet()){
            result *= (entry.getValue() + 1);
        }

        return result - 1;

    }
}
