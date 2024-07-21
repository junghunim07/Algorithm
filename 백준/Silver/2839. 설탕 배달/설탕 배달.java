import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int answer = 0;
		
		if(N % 5 == 0) {
			answer = N / 5;
		} else if (N % 5 == 1) {
			while (N != 0) {
				if (N == 6) {
					answer += 2;
					N -= 6;
				} else {
					N -= 5;
					answer++;
				}
			}
		} else if (N % 5 == 2) {
			if (N == 7) {
				answer = -1;
			} else if (N == 12) {
				answer = 4;
			} else {
				while(N != 0) {
					N -= 5;
					answer++;
					if (N == 12) {
						N-= 12;
						answer += 4;
					}
				}
			}
		} else if (N % 5 == 3) {
			answer = N / 5;
			answer += 1;
		} else if (N % 5 == 4) {
			if (N == 4) {
				answer = -1;
			} else if (N == 9) {
				answer += 3;
			} else {
				while(N != 0) {
					N -= 5;
					answer++;
					if (N == 9) {
						N -= 9;
						answer += 3;
					}
				}
			}
		} 
		
		System.out.println(answer);
	}
}