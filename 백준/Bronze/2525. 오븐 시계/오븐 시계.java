import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		int c = sc.nextInt();
		
		m += (h * 60 + c);
		h = (m / 60);
		m -= (h * 60);
		
		if (h > 23) {
			h -= 24;
		}
		
		System.out.println(h + " " + m);
    }
}