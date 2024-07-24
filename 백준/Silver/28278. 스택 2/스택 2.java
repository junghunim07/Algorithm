import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<String> stack = new Stack<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("1")) {
                save(st.nextToken());
            } else if (command.equals("2")) {
                printTopAndPop();
            } else if (command.equals("3")) {
                count();
            } else if (command.equals("4")) {
                checkEmpty();
            } else {
                printTop();
            }
        }
    }

    public static void save(String a) {
        stack.push(a);
    }

    public static void printTopAndPop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.pop());
        }
    }

    public static void count() {
        System.out.println(stack.size());
    }

    public static void checkEmpty() {
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void printTop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
        }
    }
}
