import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            String[] phoneNumbers = new String[N];

            for (int j = 0; j < N; j++) {
                phoneNumbers[j] = br.readLine();
            }

            Arrays.sort(phoneNumbers);

            if (isConsistent(N, phoneNumbers)) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }

        System.out.println(sb);
    }

    static boolean isConsistent(int N, String[] phoneNumbers) {
        for (int i = 0; i < N - 1; i++) {
            if (phoneNumbers[i + 1].startsWith(phoneNumbers[i])) {
                return false;
            }
        }
        return true;
    }
}
