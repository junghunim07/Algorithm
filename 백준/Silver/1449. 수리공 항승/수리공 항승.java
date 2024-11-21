import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {

    static int N;
    static int L;
    static PriorityQueue<Integer> hole;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        hole = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            hole.add(sc.nextInt());
        }

        solve();
    }

    static void solve() {
        int count = 0;
        int now = 0;

        while (!hole.isEmpty()) {
            if (now == 0) {
                now = hole.poll();
                count++;
                now += L - 1;
            } else {
                if (hole.peek() <= now) {
                    hole.poll();
                    continue;
                }

                now = hole.poll();
                count++;
                now += L - 1;
            }
        }

        System.out.println(count);
    }
}