import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(include(str, n, s));
    }

    static int include(String input, int count, int total) {
        int result = 0;
        int cnt = 0;

        for (int i = 1; i < total - 1;) {
            if (input.charAt(i) == 'O' && input.charAt(i + 1)== 'I') {
                cnt++;

                if (cnt == count) {
                    if (input.charAt(i - (cnt * 2 - 1)) == 'I') {
                        result++;
                    }
                    cnt--;
                }
                i += 2;
            } else {
                cnt = 0;
                i++;
            }
        }

        return result;
    }
}
