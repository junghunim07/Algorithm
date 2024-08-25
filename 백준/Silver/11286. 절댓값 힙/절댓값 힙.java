import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int x = Math.abs(o1);
                int y = Math.abs(o2);

                if (x > y) {
                    return 1;
                } else if (x < y) {
                    return -1;
                } else {
                    if (o1 == o2) {
                        return 0;
                    } else {
                        if (o1 > o2) {
                            return 1;
                        } else {
                            return -1;
                        }
                    }
                }
            }
        });

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(br.readLine());

            if (a == 0) {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            } else {
                queue.add(a);
            }
        }
    }
}
