import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int h = sc.nextInt();
		int m = sc.nextInt();
		
		if (m < 45) {
			m += 60;
			
			if (h == 0) {
				h = 23 ;
				m -= 45;
			} else {
				h -= 1;
				m -= 45;
			}
		} else {
			if (h == 0) {
				m -= 45;
			} else {
				m -= 45;
			}
		}
		System.out.println(h + " " + m);
    }
}