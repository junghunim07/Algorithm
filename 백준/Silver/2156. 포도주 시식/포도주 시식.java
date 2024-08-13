import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] grapeJuice = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            grapeJuice[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = grapeJuice[1];
        if (n > 1) {
            dp[2] = grapeJuice[1] + grapeJuice[2];
        }

        for (int i = 3; i <= n; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2] + grapeJuice[i], dp[i - 3] + grapeJuice[i - 1] + grapeJuice[i]));
        }

        System.out.println(dp[n]);
    }
}
