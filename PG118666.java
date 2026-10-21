import java.util.HashMap;

public class PG118666 {
    public static void main(String[] args) {
        PG118666 sol = new PG118666();

        System.out.println(sol.solution(new String[]{"TR", "RT", "TR"}, new int[]{7, 1, 3}));
    }

    public String solution(String[] survey, int[] choices){
        String answer = "";
        HashMap<String, Integer> hash = new HashMap<>();
        hash.put("A", 0);
        hash.put("N", 0);
        hash.put("J", 0);
        hash.put("M", 0);
        hash.put("C", 0);
        hash.put("F", 0);
        hash.put("R", 0);
        hash.put("T", 0);
        for(int i = 0; i < survey.length; i++){
            String[] input = survey[i].split("");
            int choice = choices[i];
            String first = input[0];
            String second = input[1];
            if(choice == 1){
                hash.put(first, hash.get(first) + 3);
            } else if(choice == 2){
                hash.put(first, hash.get(first) + 2);
            } else if(choice == 3){
                hash.put(first, hash.get(first) + 1);
            } else if(choice == 4){
                continue;
            } else if(choice == 5){
                hash.put(second, hash.get(second) + 1);
            } else if(choice == 6){
                hash.put(second, hash.get(second) + 2);
            } else if(choice == 7){
                hash.put(second, hash.get(second) + 3);
            } 
        }

        if(hash.get("R") >= hash.get("T")){
            answer += "R";
        } else {
            answer += "T";
        }

        if(hash.get("C") >= hash.get("F")){
            answer += "C";
        } else {
            answer += "F";
        }

        if(hash.get("J") >= hash.get("M")){
            answer += "J";
        } else {
            answer += "M";
        }

        if(hash.get("A") >= hash.get("N")){
            answer += "A";
        } else {
            answer += "N";
        }

        
        
        return answer;
    }
}
