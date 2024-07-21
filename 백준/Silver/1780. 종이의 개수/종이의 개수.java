import java.util.*;

public class Main {
	public static int[][] paper;
	public static int count0;
	public static int count1;
	public static int count2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		paper = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				paper[i][j] = sc.nextInt();
				
			}
		}
		
		getCountPaper(0, 0, N);
		
		System.out.println(count2);
		System.out.println(count0);
		System.out.println(count1);
	}
	
	public static void getCountPaper(int row, int col, int N) {
		if(sameNumberCheck(row, col, N)) {
			if (paper[row][col] == 0) {
				count0++;
			} else if (paper[row][col] == 1) {
				count1++;
			} else {
				count2++;
			}
			
			return;
		}
		
		int size = N / 3;
		
		getCountPaper(row, col, size);
		getCountPaper(row, col + size, size);
		getCountPaper(row, col + 2 * size, size);
		
		getCountPaper(row + size, col, size);
		getCountPaper(row + size, col + size, size);
		getCountPaper(row + size, col + 2 * size, size);
		
		getCountPaper(row + 2 * size, col, size);
		getCountPaper(row + 2 * size, col + size, size);
		getCountPaper(row + 2 * size, col + 2 * size, size);
	}
	
	public static boolean sameNumberCheck(int row, int col, int N) {
		int num = paper[row][col];
		
		for (int i = row; i < row + N; i++) {
			for (int j = col; j < col + N; j++) {
				if (num != paper[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}