import java.io.BufferedReader;
import java.io.InputStreamReader;

public class JO14108 {
    static String Ime = "";
    static String Prezime = "";
    static String Datum = "";
    static String OIB = "";
    static String input1, input2, input3;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input1 = br.readLine();
        input2 = br.readLine();
        input3 = br.readLine();

        int name_index = 0;
        for(int i = 0; i < input3.length(); i++){ // 이름과 성을 구하는 단계
            if(input3.charAt(i) != '<'){
                Ime += input3.charAt(i);
            } else {
                name_index = i;
                break;
            }
        }

        for(int i = name_index + 2; i < input3.length(); i++){
            if(input3.charAt(i) != '<'){
                Prezime += input3.charAt(i);
            } else {
                break;
            }
        }

        Ime = Ime.substring(0, 1).toUpperCase() + Ime.substring(1).toLowerCase();
        Prezime = Prezime.substring(0, 1).toUpperCase() + Prezime.substring(1).toLowerCase();

        int index_oib = 0; // oib 구하는 과정
        for(int i = 0; i < input1.length(); i++){
            if(input1.charAt(i) == '<'){
                index_oib = i;
                break;
            }
        }
        OIB = input1.substring(index_oib - 11, index_oib);

        String year = input2.substring(0, 2);
        String month = input2.substring(2, 4);
        String day = input2.substring(4, 6);
        int year_int = Integer.parseInt(year);
        if(year_int <= 24){
            Datum = day + "-" + month + "-" + "20" + year;
        } else {
            Datum = day + "-" + month + "-" + "19" + year;
        }
        

        StringBuilder sb = new StringBuilder();
        sb.append("Ime: " + Ime).append("\n").append("Prezime: " + Prezime).append("\n").append("Datum rodjenja: " + Datum).append("\n").append("OIB: " + OIB);
        System.out.println(sb);
    }
}
