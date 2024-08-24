import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>();

        int n = Integer.parseInt(br.readLine());
        int last = 0;

        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(br.readLine());

            if (now > last) {
                for (int j = last + 1; j <= now; j++) {
                    stack.push(j);
                    sb.append("+\n");
                }

                last = now;
            }

            if (stack.peek() == now) {
                stack.pop();
                sb.append("-\n");
            }
        }

        if (!stack.isEmpty()) {
            System.out.println("NO");
        } else {
            System.out.println(sb);
        }
    }
}
