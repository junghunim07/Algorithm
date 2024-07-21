import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long A = sc.nextLong();
        long B = sc.nextLong();
        long C = sc.nextLong();
        System.out.println(pow(A, B, C));
    }

    public static long pow(long A, long B, long C) {
        if (B == 0) {
            return 1;
        } else if (B == 1) {
            return A % C;
        } else if (B % 2 == 0) {
            long temp = pow(A, B / 2, C);
            return (temp * temp) % C;
        } else {
            return (A * pow(A, B - 1, C)) % C;
        }
    }
}
