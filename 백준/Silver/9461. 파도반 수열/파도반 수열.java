import java.util.Scanner;

public class Main {
	static long[] dp;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new long[101];
		
		dp[0] = 0;
		for (int i = 1; i < 4; i++) {
			dp[i] = 1;
		}
		
		for (int i = 0; i < N; i++) {
			int T = sc.nextInt();
			
			System.out.println(makeTriangle(T));
		}
	}
	
	public static long makeTriangle(int i) {
		if (dp[i] == 0)
			dp[i] = makeTriangle(i - 2) + makeTriangle(i - 3);
		
		return dp[i];
	}
}