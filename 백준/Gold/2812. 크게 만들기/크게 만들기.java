import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[] input = br.readLine().toCharArray();
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (m > 0 && !deque.isEmpty() && deque.getLast() < input[i]) {
                deque.removeLast();
                m--;
            }
            deque.add(input[i]);
        }

        StringBuilder answer = new StringBuilder();

        while (deque.size() > m) {
            answer.append(deque.removeFirst());
        }

        System.out.println(answer);
    }
}
