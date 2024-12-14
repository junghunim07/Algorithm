import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] numCount = new int[10];
        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            numCount[c - '0']++;
            total += c - '0';
        }

        if (numCount[0] == 0 || total % 3 != 0) {
            System.out.println("-1");
            return;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 9; i >= 0; i--) {
            while (numCount[i] > 0) {
                sb.append(i);
                numCount[i]--;
            }
        }
        System.out.println(sb);
    }
}
