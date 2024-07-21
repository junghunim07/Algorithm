import java.util.*;

public class Main {
	static int[][] paper;
	static int blue;
	static int white;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		blue = 0;
		white = 0;
		paper = new int[n][n];
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				paper[i][j] = sc.nextInt();
			}
		}
		
		getPaper(0, 0, n);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	static void getPaper(int row, int col, int n) {
		if (samePaper(row, col, n)) {
			if (paper[row][col] == 1)
				blue++;
			else
				white++;
			return;
		}
		
		int size = n / 2;
		
		getPaper(row, col, size);
		getPaper(row, col + size, size);
		
		getPaper(row + size, col, size);
		getPaper(row + size, col + size, size);
	}
	
	static boolean samePaper(int row, int col, int n) {
		int color = paper[row][col];
		
		for(int i = row; i < row + n; i++) {
			for(int j = col; j < col + n; j++) {
				if (color != paper[i][j]) {
					return false;
				}
			}
		}
		
		return true;
	}
}