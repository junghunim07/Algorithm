import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Supplier;

public class Main {

    static Deque<Integer> deque;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        deque = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().split(" ");

            if (input.length == 2) {
                command(input[0], Integer.parseInt(input[1]));
            } else {
                process(input[0]);
            }
        }
    }

    static void process(String command) {
        switch (command) {
            case "pop_front" :
                System.out.println(popFront());
                break;
            case "pop_back" :
                System.out.println(popBack());
                break;
            case "size" :
                System.out.println(deque.size());
                break;
            case "empty" :
                System.out.println(empty());
                break;
            case "front" :
                System.out.println(front());
                break;
            case "back" :
                System.out.println(back());
                break;
        }
    }

    static void command(String command, int value) {
        switch (command) {
            case "push_front" :
                deque.addFirst(value);
                break;
            case "push_back" :
                deque.addLast(value);
                break;
        }
    }

    static int emptyHandler(Supplier<Integer> action) {
        if (deque.isEmpty()) {
            return -1;
        }
        return action.get();
    }

    static int popFront() {
        return emptyHandler(() -> deque.removeFirst());
    }

    static int popBack() {
        return emptyHandler(() -> deque.removeLast());
    }

    static int empty() {
        if (deque.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int front() {
        return emptyHandler(() -> deque.peekFirst());
    }

    static int back() {
        return emptyHandler(() -> deque.peekLast());
    }
}