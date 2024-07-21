import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int reward = 0;
		
		if (a == b && b == c && a == c) {
			reward = 10000 + a * 1000;
		} else if (a == b && a != c) {
			reward = 1000 + a * 100;
		} else if (b == c && a != b) {
			reward = 1000 + b * 100;
		} else if (a == c && a != b) {
			reward = 1000 + a * 100;
		} else {
			if (a > b && a > c) {
				reward = a * 100;
			} else if (b > a && b > c) {
				reward = b * 100;
			} else {
				reward = c * 100;
			}
		}
		
		System.out.println(reward);
    }
}