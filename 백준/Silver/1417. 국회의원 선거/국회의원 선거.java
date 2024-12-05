import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int me = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            if (i == 0) {
                me = Integer.parseInt(br.readLine());
            } else {
                pq.add(Integer.parseInt(br.readLine()));
            }
        }

        int count = 0;
        while (!pq.isEmpty()) {
            Integer max = pq.poll();

            if (me <= max) {
                max -= 1;
                pq.add(max);
                count++;
                me++;
            } else {
                break;
            }
        }

        System.out.println(count);
    }
}