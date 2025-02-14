import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static PriorityQueue<Double> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            pq.add(Double.parseDouble(st.nextToken()));
        }

        solve();

        double answer = pq.poll();

        if (answer % 10 == 0) {
            System.out.println((long) answer);
        } else {
            System.out.println(answer);
        }
    }

    static void solve() {
        while (pq.size() != 1) {
            pq.add(pq.poll() + (pq.poll() / 2));
        }
    }
}
