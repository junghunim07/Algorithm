import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = -1;
        int n = Integer.parseInt(br.readLine());

        for (int i = n / 5; i >= 0; i--) {
            if ((n - 5 * i) % 2 == 0) {
                answer = i + ((n - 5 * i) / 2);
                break;
            }
        }

        System.out.println(answer);
    }
}
