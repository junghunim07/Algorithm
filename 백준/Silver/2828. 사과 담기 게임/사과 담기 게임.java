import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()) - 1;
        int t = Integer.parseInt(br.readLine());

        int left = 1;
        int right = 1 + m;
        int answer = 0;

        for (int i = 0; i < t; i++) {
            int x = Integer.parseInt(br.readLine());

            if (x <= left) {
                answer += left - x;
                left = x;
                right = x + m;
            } else if (x >= right) {
                answer += x - right;
                right = x;
                left = x - m;
            }
        }

        System.out.println(answer);
    }
}