import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        if (k >= n) {
            System.out.println(0);
            return;
        }

        int[] censor = new int[n];
        String[] str = br.readLine().split(" ");

        for (int i = 0; i < n; i++) {
            censor[i] = Integer.parseInt(str[i]);
        }
        Arrays.sort(censor);

        int[] dif = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            dif[i] = censor[i + 1] - censor[i];
        }
        Arrays.sort(dif);

        int answer = 0;

        for (int i = 0; i < n - k; i++) {
            answer += dif[i];
        }

        System.out.println(answer);
    }
}