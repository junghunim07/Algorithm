import java.util.*;

public class Main {
	static int[] value, dp;
	static int n;
	static int k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		k = sc.nextInt();
		value = new int[n];
		dp = new int[k + 1];
		
		for (int i = 0; i < n; i++) {
			value[i] = sc.nextInt();
		}
		
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= k; j++) {
				if (j >= value[i])
					dp[j] += dp[j - value[i]];
			}
		}
		
		System.out.println(dp[k]);
	}
}