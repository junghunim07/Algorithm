import java.util.Scanner;

public class Main {
    static String answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        String[] str = new String[N];

        for (int i = 0; i < N; i++) {
            str[i] = sc.nextLine();
        }
        
        answer = str[0];

        if (str.length == 1) {
            System.out.println(answer);
        } else {
            for (int i = 1; i < str.length; i++) {
                find(str[i]);
            }

            System.out.println(answer);
        }
    }

    private static void find(String a) {
        for (int i = 0; i < a.length(); i++) {
            if (answer.charAt(i) != a.charAt(i)) {
                answer = answer.substring(0, i) + "?" + answer.substring(i+1);
            }
        }
    }
}