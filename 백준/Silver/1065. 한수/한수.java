import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 0;

        if (n < 100) {
            count += n;
        }

        if (n > 99) {
            count += 99;
            for (int i = 100; i <= n; i++) {
                String str = Integer.toString(i);
                if (str.charAt(0) == str.charAt(1)
                        && str.charAt(1) == str.charAt(2)) {
                    count++;
                } else if ((str.charAt(0) - str.charAt(1))
                        == (str.charAt(1) - str.charAt(2))) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}