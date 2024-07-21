import java.util.Scanner;

public class Main {
	static int[] dp;
	static int N;
	static int mod = 15746;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		dp = new int[N + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for (int i = 2; i <= N; i++)
			dp[i] = 0;
		
		System.out.println(fibo(N));
	}
	
	static int fibo(int n) {
		if (dp[n] == 0) {
			dp[n] = (fibo(n - 1) + fibo(n - 2)) % mod;
		}
		
		return dp[n] % mod;
	}
}