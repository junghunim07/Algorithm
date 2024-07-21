import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] answer_num = {1, 1, 2, 2, 2, 8};
		int[] num = new int[6];
		
		for(int i = 0; i < (int)num.length; i++) {
			num[i] = sc.nextInt();
		}
		
		for(int i = 0; i < (int)num.length; i++) {
			System.out.println(answer_num[i] - num[i]);
		}
    }
}