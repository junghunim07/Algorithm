import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        Integer[] length = new Integer[N];

        for (int i = 0; i < N; i++) {
            length[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(length, Collections.reverseOrder());

        for (int i = 0; i < N - 2; i++) {
            if (length[i] < length[i + 1] + length[i + 2]) {
                answer = Math.max(answer, length[i] + length[i + 1] + length[i + 2]);
            }

            if (answer > 0) break;
        }

        if (answer == 0) {
            answer = -1;
        }

        System.out.println(answer);
    }
}
