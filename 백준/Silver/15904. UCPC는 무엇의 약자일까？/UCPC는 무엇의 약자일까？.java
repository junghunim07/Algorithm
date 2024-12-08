import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        if (containsUCPC(str)) {
            System.out.println("I love UCPC");
        } else {
            System.out.println("I hate UCPC");
        }
    }

    public static boolean containsUCPC(String input) {
        char[] ucpc = {'U', 'C', 'P', 'C'};
        int index = 0;

        for (char c : input.toCharArray()) {
            if (c == ucpc[index]) {
                index++;

                if (index == ucpc.length) {
                    return true;
                }
            }
        }

        return false;
    }
}