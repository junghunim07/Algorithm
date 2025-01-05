import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K, minTime, count;
    static int[] times = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        minTime = Integer.MAX_VALUE;

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
        } else {
            bfs();
            System.out.println(minTime);
            System.out.println(count);
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(N);
        times[N] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            if (minTime < times[now]) {
                return;
            }

            for (int i = 0; i < 3; i++) {
                int next = nextStep(i, now);

                if (notValidateInRange(next)) {
                    continue;
                }

                if (next == K) {
                    minTime = Math.min(minTime, times[now]);
                    count++;
                    continue;
                }

                if (times[next] == 0 || times[next] == times[now] + 1) {
                    queue.add(next);
                    times[next] = times[now] + 1;
                }
            }
        }
    }

    static boolean notValidateInRange(int position) {
        return position < 0 || position > 100000;
    }

    static int nextStep(int i, int now) {
        if (i == 0) {
            return now + 1;
        } else if (i == 1) {
            return now - 1;
        }
        return now * 2;
    }
}
