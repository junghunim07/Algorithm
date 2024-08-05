import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Meet {
    int during;
    int cost;

    Meet(int during, int cost) {
        this.during = during;
        this.cost = cost;
    }
}

public class Main {

    static int[] dp;
    static Meet[] meets;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        meets = new Meet[N];
        dp = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            meets[i] = new Meet(a, b);
        }

        for (int i = 0; i < N; i++) {
            if (i + meets[i].during <= N) {
                dp[i + meets[i].during] = Math.max(dp[i + meets[i].during], dp[i] + meets[i].cost);
            }

            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
        }

        System.out.println(dp[N]);
    }
}
