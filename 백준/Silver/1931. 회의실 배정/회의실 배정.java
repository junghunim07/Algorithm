import java.util.*;

public class Main {
	static int[][] time;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int answer = 0;
		int fini = 0;
		
		N = sc.nextInt();
		time = new int[N][2];
		
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 2; j++) {
				time[i][j] = sc.nextInt();
			}
		}
		
		Arrays.sort(time, (o1, o2) -> {
			if(o1[1] == o2[1]) {
				return o1[0] - o2[0];
			} else {
				return o1[1] - o2[1];
			}
		});
		
		for (int i = 0; i < N; i++) {
			if(answer == 0) {
				answer++;
				fini = time[i][1];
			} else {
				if (fini <= time[i][0]) {
					answer++;
					fini = time[i][1];
				} else {
					continue;
				}
			}
		}
		
		System.out.println(answer);
	}
}