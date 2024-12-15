import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int cnt = 1;

        while (true) {
            String str = br.readLine();

            if (str.contains("-")) {
                break;
            }

            int open = 0;
            int answer = 0;

            for (int i = 0; i < str.length(); i++) {
                if (open == 0 && str.charAt(i) == '}') {
                    answer++;
                    open++;
                } else if (open > 0 && str.charAt(i) == '}') {
                    open--;
                } else if (i == str.length() - 1 && str.charAt(i) == '{') {
                    answer++;
                    open--;
                } else {
                    open++;
                }
            }

            if (open != 0) {
                answer += open / 2;
            }

            sb.append(cnt).append(". ").append(answer).append("\n");
            cnt++;
        }

        System.out.println(sb);
    }
}
