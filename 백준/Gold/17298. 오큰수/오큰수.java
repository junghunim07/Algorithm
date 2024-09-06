import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static Stack<Integer> stack;
    static int[] numbers;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        stack = new Stack<>();
        numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
           while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
               numbers[stack.pop()] = numbers[i];
           }

           stack.push(i);
        }

        while (!stack.isEmpty()) {
            numbers[stack.pop()] = -1;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            sb.append(numbers[i]).append(" ");
        }

        System.out.println(sb);
    }
}
