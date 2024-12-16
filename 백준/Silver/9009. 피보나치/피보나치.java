import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Long> answer = solution(n);

            for (Long l : answer) {
                sb.append(l).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static ArrayList<Long> solution(int target) {
        ArrayList<Long> fibonacci = new ArrayList<>();
        ArrayList<Long> answer = new ArrayList<>();

        fibonacci.add(1L);
        fibonacci.add(1L);

        int index = 2;

        while (true) {
            long next = fibonacci.get(index - 1) + fibonacci.get(index - 2);

            if (next > target) {
                break;
            }

            fibonacci.add(next);
            index++;
        }

        Collections.sort(fibonacci, Collections.reverseOrder());

        while (target != 0) {
            for (int i = 0; i < fibonacci.size(); i++) {
                if (fibonacci.get(i) <= target) {
                    target -= fibonacci.get(i);
                    answer.add(fibonacci.get(i));
                }
            }
        }

        Collections.sort(answer);
        return answer;
    }
}
