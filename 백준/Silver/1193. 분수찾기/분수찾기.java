import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int tmp = 0;

        for (int i = 1; i <= 10000; i++) {
            if (x <= i) {
                tmp = i;
                break;
            }

            x -= i;
        }

        int a = 1;
        int b = 1;

        if (tmp % 2 == 1) {
            a = tmp;
            a -= (x - 1);
            b += (x - 1);
        } else {
            b = tmp;
            a += (x - 1);
            b -= (x - 1);
        }

        System.out.printf("%d/%d", a, b);
    }
}