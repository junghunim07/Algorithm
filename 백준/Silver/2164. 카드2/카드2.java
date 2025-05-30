import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static Queue<Integer> queue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        process();
    }

    static void process() {
        if (isOnlyOne()) {
            printResult();
            return;
        }

        while (!isOnlyOne()) {
            queue.poll();

            if (isOnlyOne()) {
                printResult();
                break;
            }

            queue.add(queue.poll());
        }
    }

    static void printResult() {
        System.out.println(queue.poll());
    }

    static boolean isOnlyOne() {
        return queue.size() == 1;
    }

    static void init(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            queue.add(i);
        }
    }
}
