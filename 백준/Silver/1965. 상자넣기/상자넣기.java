import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] box = new int[n];
        int[] dp = new int[n];

        int answer = 0;

        for (int i = 0; i < n; i++) {
            box[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            dp[i] = 1;

            for (int j = 0; j < n; j++) {
                if (box[i] > box[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
