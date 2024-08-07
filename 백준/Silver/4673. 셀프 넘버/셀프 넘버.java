import java.io.*;

public class Main {

    static boolean[] number;

    public static void main(String[] args) {

        number = new boolean[10001];

        for (int i = 1; i < number.length; i++) {
            if (!number[i]) {
                int sum = i;
                for (int j = 0; j < String.valueOf(i).length(); j++) {
                    sum += Character.getNumericValue(String.valueOf(i).charAt(j));
                }
                solve(sum);
            }
        }

        for (int i = 1; i < number.length; i++) {
            if (!number[i]) {
                System.out.println(i);
            }
        }
    }

    static void solve(int a) {
        if (a > 10000) {
            return;
        }

        number[a] = true;

        int sum = a;
        for (int i = 0; i < String.valueOf(a).length(); i++) {
            sum += Character.getNumericValue(String.valueOf(a).charAt(i));
        }
        solve(sum);
    }
}
