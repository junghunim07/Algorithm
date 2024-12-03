import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] scores;
        StringTokenizer st;

        for (int i = 0; i < t; i++) {
            long answer = 0;
            int n = Integer.parseInt(br.readLine());
            scores = new int[n];
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }

            int max = scores[n - 1];

            for (int j = n - 1; j >= 0; j--) {
                if (scores[j] <= max) {
                    answer += max - scores[j];
                } else {
                    max = scores[j];
                }
            }

            System.out.println(answer);
        }
    }
}