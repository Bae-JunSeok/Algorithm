import java.util.Scanner;

public class JO1041 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        boolean found = false;

        for (int i = 1; i * i <= m; i++) {
            int square = i * i;

            if (square >= n) {
                System.out.print(square + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.print(0);
        }
    }
}