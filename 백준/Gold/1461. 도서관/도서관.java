import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> positiveQ = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> negativeQ = new PriorityQueue<>(Collections.reverseOrder());

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());

            if (temp >= 0) {
                positiveQ.offer(temp);
            } else {
                negativeQ.offer(Math.abs(temp));
            }
        }

        int maxDistance = 0;

        if (positiveQ.isEmpty()) {
            maxDistance = negativeQ.peek();
        } else if (negativeQ.isEmpty()) {
            maxDistance = positiveQ.peek();
        } else {
            maxDistance = Math.max(negativeQ.peek(), positiveQ.peek());
        }

        int answer = 0;

        while (!positiveQ.isEmpty()) {
            int temp = positiveQ.poll();

            for (int i = 0; i < m - 1; i++) {
                positiveQ.poll();

                if (positiveQ.isEmpty()) {
                    break;
                }
            }

            answer += temp * 2;
        }

        while (!negativeQ.isEmpty()) {
            int temp = negativeQ.poll();

            for (int i = 0; i < m - 1; i++) {
                negativeQ.poll();

                if (negativeQ.isEmpty()) {
                    break;
                }
            }

            answer += temp * 2;
        }

        answer -= maxDistance;

        System.out.println(answer);
    }
}
