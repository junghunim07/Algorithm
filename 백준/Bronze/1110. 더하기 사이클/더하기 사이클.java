import java.util.Scanner;

public class Main {
    static int answer;
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        answer = sc.nextInt();
        String num = Integer.toString(answer);

        if(answer < 10) {
            num = 0 + num;
        }
        getCount(num);
        System.out.println(count);
    }

    private static void getCount(String a) {
        if (count != 0 && answer == Integer.parseInt(a)) {
            return;
        }

        String tmp1 = Character.toString(a.charAt(1));
        char x = a.charAt(0);
        char y = a.charAt(1);
        String tmp2 = "";
        if (Character.getNumericValue(x) + Character.getNumericValue(y) < 10) {
            tmp2 = Integer.toString(Character.getNumericValue(x) + Character.getNumericValue(y));
        } else {
            tmp2 = Character.toString(Integer.toString(Character.getNumericValue(x) + Character.getNumericValue(y)).charAt(1));
        }
        count++;
        getCount(tmp1 + tmp2);
    }
}