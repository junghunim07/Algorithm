import java.util.*;
import java.math.*;

public class Main {
	final static int MOD = 1000;
	public static int N;
	public static int[][] origin;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		long B = sc.nextLong();
		
		origin = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				origin[i][j] = sc.nextInt() % MOD;
			}
		}
		
		int[][] result = pow(origin, B);
		
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sb.append(result[i][j]).append(' ');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}
	
	public static int[][] pow(int[][] A, long exp) {
		if (exp == 1L)
			return A;
		
		int[][] ret = pow(A, exp / 2);
		
		ret = multiply(ret, ret);
		
		if (exp % 2 == 1L)
			ret = multiply(ret, origin);
		
		return ret;
	}
	
	public static int[][] multiply(int[][] o1, int[][] o2) {
		int[][] ret = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				for (int k = 0; k < N; k++) {
					ret[i][j] += o1[i][k] * o2[k][j];
					ret[i][j] %= MOD;
				}
			}
		}
		
		return ret;
	}
}