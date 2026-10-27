import java.util.ArrayList;
import java.util.stream.Collector.Characteristics;

public class PG177677 {
    public static void main(String[] args) {
        PG177677 sol = new PG177677();
        System.out.println(sol.solution("france", "french"));
    }

    public int solution(String str1, String str2){
        int answer = 0;
        ArrayList<String> arr1 = new ArrayList<>();
        ArrayList<String> arr2 = new ArrayList<>();
        double mother = 0;
        double son = 0;
        String s = "";
        for(int i = 0; i < str1.length(); i++){
            if(Character.isAlphabetic(str1.charAt(i))){
                s += str1.charAt(i);
            } else {
                s = "";
                continue;
            }


            if(s.length() == 2){
                s = s.toLowerCase();
                arr1.add(s);
                s = "";
                i = i - 1;
            }
            
        }

        s = "";
        for(int i = 0; i < str2.length(); i++){
            if(Character.isAlphabetic(str2.charAt(i))){
               s += str2.charAt(i); 
            } else {
                s = "";
                continue;
            }

            if(s.length() == 2){
                s = s.toLowerCase();
                arr2.add(s);
                s = "";
                i = i - 1;
            }
        }

        if(arr1.isEmpty() && arr2.isEmpty()){
            return 65536;
        }

        int size1 = arr1.size();
        int size2 = arr2.size();

        for(int i = 0; i < arr2.size(); i++){
            for(int j = 0; j < arr1.size(); j++){
                if(arr2.get(i).equals(arr1.get(j))){
                    son++;
                    arr1.remove(j);
                    break;
                }
            }
        }
        
        mother = size1 + size2 - son;

        double result = 0;
        result = (son / mother) * 65536;

        answer = (int) result;

        return answer;
    }
}
