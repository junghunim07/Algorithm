import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int L = sc.nextInt();
        int W = sc.nextInt();
        int H = sc.nextInt();

        double low = 0;
        double high = Math.min(L, Math.min(W, H));
        double mid;

        while (low < high) {
            mid = (low + high) / 2;

            if ((long)(L / mid) * (long)(W / mid) * (long)(H / mid) < N) {
                if (high == mid) break;
                high = mid;
            } else {
                if (low == mid) break;
                low = mid;
            }
        }

        System.out.println(low);
    }
}
