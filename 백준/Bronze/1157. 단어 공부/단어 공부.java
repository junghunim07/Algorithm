import java.util.Arrays;
import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.nextLine();
		str = str.toLowerCase();
		
		int[] answer1 = new int[26];
		int[] answer2 = new int[26];
		
		for(int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - (int) 'a';
			answer1[index]++;
			answer2[index]++;
		}
		
		Arrays.sort(answer1);
		
		if(answer1[answer1.length - 1] == answer1[answer1.length - 2]) {
			System.out.println("?");
		} else {
			for(int i = 0; i < answer2.length; i++) {
				if(answer1[answer1.length - 1] == answer2[i]) {
					char answer = (char)('a' + i);
					answer = Character.toUpperCase(answer);
					
					System.out.println(answer);
				}
			}
		}
    }
}