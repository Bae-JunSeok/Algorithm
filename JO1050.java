import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JO1050 {
    static StringBuilder sb = new StringBuilder();
    static String[][] result = new String[4][13];
    static String n;

    static String suitOrder = "CDSH";
    static String rankOrder = "23456789TJQKA";
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = br.readLine();
        for(int i = 0; i < 2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                sb.append(st.nextToken());
            }
        }
        String s = sb.toString();

        // if(n.equals("N")){ // 북쪽
        //     for(int i = 0; i < s.length(); i = i + 2){
        //         String a = ""+ s.charAt(i) + s.charAt(i + 1);
        //         for(int j = 0; j < 13; j++){
        //             for(int k = 3; k < 7; k++){
        //                 result[k % 4][j] = a;
        //             }
        //         }
        //     }
        // } else if(n.equals("E")){ // 동쪽
        //     for(int i = 0; i < s.length(); i = i + 2){
        //         String a = ""+ s.charAt(i) + s.charAt(i + 1);
        //         for(int j = 0; j < 13; j++){
        //             for(int k = 0; k < 4; k++){
        //                 result[k % 4][j] = a;
        //             }
        //         }
        //     }
        // } else if(n.equals("S")){ // 남쪽
        //     for(int i = 0; i < s.length(); i = i + 2){
        //         String a = ""+ s.charAt(i) + s.charAt(i + 1);
        //         for(int j = 0; j < 13; j++){
        //             for(int k = 1; k < 5; k++){
        //                 result[k % 4][j] = a;
        //             }
        //         }
        //     }
        // } else { // 서쪽
        //     for(int i = 0; i < s.length() - 1; i = i + 2){
        //         String a = ""+ s.charAt(i) + s.charAt(i + 1);
        //         for(int j = 0; j < 13; j++){
        //             for(int k = 2; k < 6; k++){
        //                 result[k % 4][j] = a;
        //             }
        //         }
        //     }
        // }
        int start;

        if (n.equals("N")) {
            start = 3; // E
        } else if (n.equals("E")) {
            start = 0; // S
        } else if (n.equals("S")) {
            start = 1; // W
        } else {
            start = 2; // N
        }

        int cardIndex = 0;

        for (int i = 0; i < s.length(); i += 2) {
            String card = "" + s.charAt(i) + s.charAt(i + 1);

            int person = (start + cardIndex) % 4;
            int count = cardIndex / 4;

            result[person][count] = card;

            cardIndex++;
        }

        for (int i = 0; i < 4; i++) {
            Arrays.sort(result[i], new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    char suit1 = o1.charAt(0);
                    char rank1 = o1.charAt(1);

                    char suit2 = o2.charAt(0);
                    char rank2 = o2.charAt(1);

                    if (suit1 != suit2) {
                        return suitOrder.indexOf(suit1) - suitOrder.indexOf(suit2);
                    }

                    return rankOrder.indexOf(rank1) - rankOrder.indexOf(rank2);
                }
            });
        }


        StringBuilder sbResult = new StringBuilder();
        sbResult.append("S: ");
        for(int i = 0; i < 13; i++){
            sbResult.append(result[0][i] + " ");
        }
        sbResult.append("\n");
        
        sbResult.append("W: ");
        for(int i = 0; i < 13; i++){
            sbResult.append(result[1][i] + " ");
        }
        sbResult.append("\n");

        sbResult.append("N: ");
        for(int i = 0; i < 13; i++){
            sbResult.append(result[2][i] + " ");
        }
        sbResult.append("\n");

        sbResult.append("E: ");
        for(int i = 0; i < 13; i++){
            sbResult.append(result[3][i] + " ");
        }
        sbResult.append("\n");

        System.out.println(sbResult);
    }
}
