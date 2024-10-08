import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 1;
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (a != b) {
            if (b < a) {
                System.out.println(-1);
                return;
            }

            String str = String.valueOf(b);

            if (b % 2 == 0) {
                b /= 2;
            } else if (str.charAt(str.length() - 1) == '1') {
                str = str.substring(0, str.length() - 1);
                b = Integer.parseInt(str);
            } else {
                System.out.println(-1);
                return;
            }
            count++;
        }

        System.out.println(count);
    }
}
