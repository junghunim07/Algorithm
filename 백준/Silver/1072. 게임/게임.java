import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        long Y = sc.nextLong();
        long Z = (Y * 100) / X;
        long cnt = 0;

        if (Z >= 99) {
            cnt = -1;
        } else {
            long start = 0;
            long end = 2000000000;

            while (start < end) {
                long mid = (start + end) / 2;
                long ret = 100 * (Y + mid) / (X + mid);

                if (ret > Z) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            cnt = end;
        }

        System.out.println(cnt);
    }
}
