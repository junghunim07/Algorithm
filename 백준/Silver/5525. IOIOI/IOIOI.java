import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int s = Integer.parseInt(br.readLine());
        String str = br.readLine();

        System.out.println(include(str, makeFindString(n)));
    }

    static int include(String input, String target) {
        int count = 0;
        int index = 0;

        while ((index = input.indexOf(target, index)) != -1) {
            count++;
            index++;
        }

        return count;
    }

    static String makeFindString(int cnt) {
        StringBuilder prefix = new StringBuilder("I");

        for (int i = 0; i < cnt; i++) {
            prefix.append("OI");
        }

        return prefix.toString();
    }
}
