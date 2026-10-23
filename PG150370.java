import java.util.ArrayList;

public class PG150370 {
    public static void main(String[] args) {
        PG150370 sol = new PG150370();
        sol.solution("2022.05.19", new String[]{"A 6", "B 12", "C 3"}, new String[]{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"});
    }

    public int[] solution(String today, String[] terms, String[] privacies){
        
        ArrayList<Integer> result = new ArrayList<>();
        int n = privacies.length;
        String[] t = today.split("\\.");
        int year = Integer.parseInt(t[0]);
        int month = Integer.parseInt(t[1]);
        int day = Integer.parseInt(t[2]);

        String[] a = new String[terms.length];
        int[] b = new int[terms.length];

        for(int i = 0; i < terms.length; i++){
            String[] c = terms[i].split(" ");
            a[i] = c[0];
            b[i] = Integer.parseInt(c[1]);
        }

        for(int i = 0; i < n; i++){
            String[] e = privacies[i].split(" ");
            String grade = e[1];
            String[] splitDate = e[0].split("\\.");
            int y = Integer.parseInt(splitDate[0]);
            int m = Integer.parseInt(splitDate[1]);
            int d = Integer.parseInt(splitDate[2]);
            int rY = year - y;
            int rM = month - m;
            int rD = day - d;
            if(rD < 0){
                rM -= 1;
                rD += 28;
            }

            if(rM < 0){
                rY -= 1;
                rM += 12;
            }

            int fResult = rY * 12 * 28 + rM * 28 + rD;

            for(int j = 0; j < terms.length; j++){
                if(grade.equals(a[j])){
                    if(fResult >= b[j] * 28){
                        result.add(i + 1);
                    }
                }
            }
        }


        int[] answer = new int[result.size()];
        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
            System.out.println(result.get(i));
        }

        return answer;
    }
}
