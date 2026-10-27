import java.util.ArrayList;
import java.util.Arrays;

public class PG17686 {
    public static void main(String[] args) {
        PG17686 sol = new PG17686();
        System.out.println(sol.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"}));
    }

    public String[] solution(String[] files){
        ArrayList<String> result = new ArrayList<>();

        Arrays.sort(files, (a, b) -> {
            String forA = "", forB = "";
            int indexA = 0, indexB = 0;
            String c = "", d = "";
            int forANumber = 0, forBNumber = 0;
            for(int i = 0; i < a.length(); i++){
                if(Character.isDigit(a.charAt(i))){
                    indexA = i;
                    break;
                } else {
                    forA += a.charAt(i);
                }
            }

            for(int i = indexA; i < a.length(); i++){
                if(Character.isDigit(a.charAt(i))){
                    c += a.charAt(i);
                } else {
                    break;
                }
            }

            for(int i = 0; i < b.length(); i++){
                if(Character.isDigit(b.charAt(i))){
                    indexB = i;
                    break;
                } else {    
                    forB += b.charAt(i);
                }
            }

            for(int i = indexB; i < b.length(); i++){
                if(Character.isDigit(b.charAt(i))){
                    d += b.charAt(i);
                } else {
                    break;
                }
            }

            forANumber = Integer.parseInt(c);
            forBNumber = Integer.parseInt(d);

            forA = forA.toLowerCase();
            forB = forB.toLowerCase();

            if(forA.equals(forB)){ // 앞에 글씨가 같으면 숫자 비교해서
                return forANumber - forBNumber;
            } else { // 다르면 그냥 글씨 비교로
                return forA.compareTo(forB);
            }
        });

        for(int i = 0; i < files.length; i++){
            result.add(files[i]);
        }


        String[] answer = new String[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
