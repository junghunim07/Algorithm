import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long N;
    static int[] dice = new int[6];
    static long[] num = new long[4];
    static int[] min = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        num[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        num[2] = 8 * (N - 2) + 4;
        num[3] = 4;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 6; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        setMinIndex();

        if (N == 1) {
            Arrays.sort(dice);
            long sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += dice[i];
            }
            System.out.println(sum);
        } else {
            long sum = num[1] * min[0] + num[2] * (min[0] + min[1]) + num[3] * (min[0] + min[1] + min[2]);
            System.out.println(sum);
        }
    }

    static void setMinIndex() {
        min[0] = Math.min(dice[0], dice[5]);
        min[1] = Math.min(dice[1], dice[4]);
        min[2] = Math.min(dice[2], dice[3]);

        Arrays.sort(min);
    }
}