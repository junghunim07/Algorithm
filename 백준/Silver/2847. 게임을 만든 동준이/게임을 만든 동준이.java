import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        scores = new int[n];

        for (int i = 0; i < n; i++) {
            scores[i] = Integer.parseInt(br.readLine());
        }

        int count = 0;
        int now = scores[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (now <= scores[i]) {
                count += scores[i] - (now - 1);
                now -= 1;
            } else {
                now = scores[i];
            }
        }

        System.out.println(count);
    }
}