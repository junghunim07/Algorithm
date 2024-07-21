import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int sum = Integer.MAX_VALUE;
		String[] subtraction = sc.nextLine().split("-");
		
		for(int i = 0; i < subtraction.length; i++) {
			int tmp = 0;
			
			String[] addition = subtraction[i].split("\\+");
			
			for(int j = 0; j <addition.length; j++) {
				tmp += Integer.parseInt(addition[j]);
			}
			
			if (sum == Integer.MAX_VALUE) {
				sum = tmp;
			} else {
				sum -= tmp;
			}
		}
        System.out.println(sum);
	}
}