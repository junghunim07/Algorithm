import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int length = input.length();
        int count = 0;

        for (int i = 0; i < length; i++) {
            if (input.charAt(i) == 'c' && i < length - 1) {
                if (input.charAt(i + 1) == '=' || input.charAt(i + 1) == '-') {
                    i++;
                }
            }

            if (input.charAt(i) == 'd' && i < length - 1) {
                if (input.charAt(i + 1) == '-') {
                    i++;
                } else if (input.charAt(i + 1) == 'z' && i < length - 2) {
                    if (input.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            }

            if ((input.charAt(i) == 'l' || input.charAt(i) == 'n') && i < length - 1) {
                if (input.charAt(i + 1) == 'j') {
                    i++;
                }
            }

            if ((input.charAt(i) == 's' || input.charAt(i) == 'z') && i < length - 1) {
                if (input.charAt(i + 1) == '=') {
                    i++;
                }
            }

            count += 1;
        }
        System.out.println(count);
    }
}
