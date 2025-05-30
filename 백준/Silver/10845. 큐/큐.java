import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;

public class Main {

    static Deque<Integer> queue;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        queue = new LinkedList<>();

        process(br);
        System.out.println(sb);
    }

    static void process(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            String command = br.readLine();

            if (command.contains("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
                continue;
            }

            execute(command);
        }
    }

    static void execute(String command) {
        switch (command) {
            case "front" :
                sb.append(front()).append("\n");
                break;
            case "pop" :
                sb.append(pop()).append("\n");
                break;
            case "size" :
                sb.append(size()).append("\n");
                break;
            case "empty" :
                sb.append(empty()).append("\n");
                break;
            case "back" :
                sb.append(back()).append("\n");
                break;
        }
    }

    static int back() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.peekLast();
    }

    static int empty() {
        if (queue.isEmpty()) {
            return 1;
        }
        return 0;
    }

    static int size() {
        return queue.size();
    }

    static int pop() {
        if (queue.isEmpty()) {
            return -1;
        }
        return queue.pollFirst();
    }

    static int front() {
        if (queue.isEmpty()) {
            return -1;
        }

        return queue.peekFirst();
    }

    static void push(int target) {
        queue.add(target);
    }
}
