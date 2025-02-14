import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int N;
    static char[] basic;
    static char[] pressSwitch;
    static char[] want;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        basic = setUpSwitch(br.readLine());
        want = setUpSwitch(br.readLine());

        pressSwitch = Arrays.copyOf(basic, N);
        pressSwitch[0] = pressSwitch[0] == '1' ? '0' : '1';
        pressSwitch[1] = pressSwitch[1] == '1' ? '0' : '1';

        int basicCount = solve(0, basic, want);
        int pressSwitchCount = solve(1, pressSwitch, want);

        if (isSame(basic, want)) {
            System.out.println(basicCount);
        } else if (isSame(pressSwitch, want)) {
            System.out.println(pressSwitchCount);
        } else {
            System.out.println(-1);
        }
    }

    static boolean isSame(char[] input, char[] target) {
        for (int i = 0; i < N; i++) {
            if (input[i] != target[i]) {
                return false;
            }
        }
        return true;
    }

    static int solve(int cnt, char[] input, char[] target) {
        for (int i = 1; i < N; i++) {
            if (input[i - 1] != target[i - 1]) {
                cnt++;

                input[i - 1] = input[i - 1] == '1' ? '0' : '1';
                input[i] = input[i] == '1' ? '0' : '1';

                if (i + 1 < N) {
                    input[i + 1] = input[i + 1] == '1' ? '0' : '1';
                }
            }
        }

        return cnt;
    }

    static char[] setUpSwitch(String input) {
        return input.toCharArray();
    }
}
