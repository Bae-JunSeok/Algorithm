public class n의배수 {
    public static void main(String[] args) {
        n의배수 sol = new n의배수();

        int answer = sol.solution(34, 3);

        System.out.println(answer);
    }

    public int solution(int num, int n) {
        int answer = 0;
        if(num % n == 0){
            answer = 1;
        } else {
            answer = 0;
        }
        return answer;
    }
}
