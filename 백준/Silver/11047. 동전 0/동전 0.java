import java.util.*;

public class Main {
	static int[] coin;
	static int N;
	static int K;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int count = 0;
		
		N = sc.nextInt();
		K = sc.nextInt();
		coin = new int[N];
		
		for(int i = 0; i < N; i++) {
			coin[i] = sc.nextInt();
		}
		
		for (int i = N - 1; i >= 0; i--) {
			if (K >= coin[i]) {
				count += K / coin[i];
				K = K % coin[i];
			} else {
				continue;
			}
		}
		
		System.out.println(count);
	}
}