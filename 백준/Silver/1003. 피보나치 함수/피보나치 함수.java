import java.util.Scanner;

public class Main {
    static int[] memo;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        memo = new int[42];
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 1;

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            fibonacci(num[i]);
        }

        for (int i = 0; i < n; i++) {
            if (num[i] > 1) {
                System.out.println(memo[num[i] - 1] + " " + memo[num[i]]);
            } else if (num[i] == 0){
                System.out.println(memo[1] + " " + memo[0]);
            } else {
                System.out.println(memo[0] + " " + memo[1]);
            }
        }
    }

    private static int fibonacci(int n) {
        if (n == 0)
            return memo[n] = 0;
        if (n == 1)
            return memo[n] = 1;
        if (memo[n] != 0) {
            return memo[n];
        }
        return memo[n] = fibonacci(n - 1) + fibonacci(n- 2);
    }
}