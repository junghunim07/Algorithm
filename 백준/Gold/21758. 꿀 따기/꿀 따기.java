import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static long total, max;

    static int[] honeys;
    static long[] rightTotal;
    static long[] leftTotal;

    public static void main(String[] args) throws IOException {
        init();

        /*case1();
        case2();
        case3();*/

        System.out.println(max);
    }

    static void case1() {
        long bee1, bee2;

        for (int i = 1; i <= N - 2; i++) {
            bee1 = total - honeys[0] - honeys[i];
            bee2 = total - rightTotal[i];
            max = Math.max(max, bee1 + bee2);
        }
    }

    static void case2() {
        long bee1, bee2;

        for (int i = N - 2; i >= 1; i--) {
            bee1 = total - honeys[0] - honeys[i];
            bee2 = total - leftTotal[i];
            max = Math.max(max, bee1 + bee2);
        }
    }

    static void case3() {
        long bee1, bee2;

        for (int i = 1; i <= N - 2; i++) {
            bee1 = rightTotal[i] - honeys[0];
            bee2 = leftTotal[i] - honeys[N - 1];
            max = Math.max(max, bee1 + bee2);
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        honeys = new int[N];
        rightTotal = new long[N];
        leftTotal = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        long tmp = 0;

        for (int i = 0; i < N; i++) {
            honeys[i] = Integer.parseInt(st.nextToken());

            tmp += honeys[i];
            rightTotal[i] = tmp;
        }

        tmp = 0;
        for (int i = N - 1; i >= 0; i--) {
            tmp += honeys[i];
            leftTotal[i] = tmp;
        }

        total = rightTotal[N - 1];

        for (int i = 1; i < N - 1; i++) {
            max = Math.max(max, total - honeys[i] - honeys[0] + total - rightTotal[i]);
            max = Math.max(max, total - honeys[i] - honeys[N - 1] + total - leftTotal[i]);
            max = Math.max(max, rightTotal[i] + leftTotal[i] - honeys[0] - honeys[N - 1]);
        }
    }
}
