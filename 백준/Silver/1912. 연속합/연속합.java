import java.util.Scanner;
import java.lang.Math;

public class Main {
	static int[] dp;
	static int[] num;
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		n = sc.nextInt();
		dp = new int[n];
		num = new int[n];
		
		for (int i = 0; i < n; i++) {
			num[i] = sc.nextInt();
		}
		
		dp[0] = num[0];
		int max = num[0];
		
		for (int i = 1; i < n; i++) {
			dp[i] = Math.max(num[i], dp[i - 1] + num[i]);
			
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
}