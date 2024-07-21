import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[][] dp = new int[30][30];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            sb.append(combination(N, M)).append('\n');
        }

        System.out.println(sb);
    }

    private static int combination(int n, int m) {
        if (dp[m][n] > 0) {
            return dp[m][n];
        }

        if (m == n || n == 0) {
            return dp[m][n] = 1;
        }

        return dp[m][n] = combination(n - 1, m - 1) + combination(n, m - 1);
    }
}