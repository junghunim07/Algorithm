import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int RED = 0;
    static final int GREEN = 1;
    static final int BLUE = 2;
    static int N, answer;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(
                Math.min(setMinCostColor(N - 1, RED), setMinCostColor(N - 1, GREEN)
                ), setMinCostColor(N - 1, BLUE)));
    }

    static int setMinCostColor(int n, int color) {

        if (dp[n][color] == 0) {

            if (color == RED) {
                dp[n][RED] = Math.min(setMinCostColor(n - 1, GREEN), setMinCostColor(n - 1, BLUE)) + cost[n][RED];
            } else if (color == GREEN) {
                dp[n][GREEN] = Math.min(setMinCostColor(n - 1, RED), setMinCostColor(n - 1, BLUE)) + cost[n][GREEN];
            } else {
                dp[n][BLUE] = Math.min(setMinCostColor(n - 1, RED), setMinCostColor(n - 1, GREEN)) + cost[n][BLUE];
            }
        }

        return dp[n][color];
    }
}
