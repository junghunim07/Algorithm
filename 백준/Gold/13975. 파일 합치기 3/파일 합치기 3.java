import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int K;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            K = Integer.parseInt(br.readLine());
            pq = new PriorityQueue<>();

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < K; i++) {
                pq.offer(Long.parseLong(st.nextToken()));
            }

            System.out.println(union());
        }
    }

    static long union() {
        long answer = 0;
        while (pq.size() > 1) {
            long c = pq.poll() + pq.poll();
            pq.offer(c);
            answer += c;
        }
        return answer;
    }
}
