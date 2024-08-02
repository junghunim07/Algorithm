import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static Stack<Integer> stack;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" :
                    push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    pop();
                    break;
                case "size" :
                    size();
                    break;
                case "empty" :
                    empty();
                    break;
                case "top" :
                    top();
                    break;
            }
        }
    }

    static void push(int X) {
        stack.push(X);
    }

    static void pop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.pop());
        }
    }

    static void size() {
        System.out.println(stack.size());
    }

    static void empty() {
        if (stack.isEmpty()) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    static void top() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        } else {
            System.out.println(stack.peek());
        }
    }
}
