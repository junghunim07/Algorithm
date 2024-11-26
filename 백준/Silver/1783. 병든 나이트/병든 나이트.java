import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int answer = 0;

        if (n == 1 || m == 1) {
            answer = 1;
        } else {
            if (n < 3) {
                answer = Math.min(3, (m - 1) / 2) + 1;
            } else if (m < 7) {
                answer = Math.min(3, m - 1) + 1;
            } else {
                answer = m - 2;
            }
        }

        System.out.println(answer);
    }
}