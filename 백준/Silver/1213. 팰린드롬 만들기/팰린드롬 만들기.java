import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        String name = br.readLine();
        int[] count = new int[26];
        boolean check = false;

        for (int i = 0; i < name.length(); i++) {
            count[name.charAt(i) - 'A']++;
        }

        int cnt = 0;
        int mid = 0;

        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0) {
                cnt++;
                mid = i;
            }

            if (cnt > 1) {
                System.out.println("I'm Sorry Hansoo");
                check = true;
                break;
            }

            for (int j = 0; j < count[i] / 2; j++) {
                sb.append((char)(i + 'A'));
            }
        }

        if (!check) {
            String answer = sb.toString();

            if (cnt == 1) {
                answer += (char)(mid + 'A');
            }

            answer += sb.reverse().toString();

            System.out.println(answer);
        }
    }
}
