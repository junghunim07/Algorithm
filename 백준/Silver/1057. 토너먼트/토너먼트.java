import java.util.*;

public class Main {
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int kim = sc.nextInt();
        int lim = sc.nextInt();

        find(kim, lim);

        System.out.println(count);
    }

    private static void find(int kim, int lim) {
        if ((kim % 2) == 1) {
            kim += 1;
        }

        if ((lim % 2) == 1) {
            lim += 1;
        }

        if (kim == lim) {
            count++;
            return;
        }

        count++;
        find(kim / 2, lim / 2);
    }
}