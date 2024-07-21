import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int N = sc.nextInt();
        int M = sc.nextInt();
        int x = 0;
        int y = 0;

        while (true) {
            if ((N - 2) <= 0 || (M - 2) <= 0) {
                break;
            }
            N -= 2;
            M -= 2;
            cnt++;
        }

        if (N >= M) {
            if (M == 1) {
                x = (N - 1) + cnt;
                y = cnt;
            } else {
                x = cnt;
                y = cnt + 1;
            }
        } else {
            if (N == 1) {
                x = cnt;
                y = (M - 1) + cnt;
            } else {
                x = cnt;
                y = cnt + 1;
            }
        }

        System.out.println(x + " " + y);
    }
}
