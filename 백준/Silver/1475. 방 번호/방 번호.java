import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] used;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        used = new int[9];

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '9' || str.charAt(i) == '6') {
                used[6]++;
            } else {
                used[Character.getNumericValue(str.charAt(i))]++;
            }
        }

        if (used[6] % 2 != 0) {
            used[6] /= 2;
            used[6] += 1;
        } else {
            used[6] /= 2;
        }

        System.out.println(get());
    }

    static int get() {
        int max = Integer.MIN_VALUE;
        for (int i : used) {
            max = Math.max(max, i);
        }
        return max;
    }
}