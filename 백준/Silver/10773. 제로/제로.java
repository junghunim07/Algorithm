import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());

            if (tmp == 0) {
                st.pop();
            } else {
                st.push(tmp);
            }
        }

        int sum = 0;

        while (!st.isEmpty()) {
            sum += st.pop();
        }

        System.out.println(sum);
    }
}
