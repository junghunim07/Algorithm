import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static double[] x;
    static double[] y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        x = new double[N + 1];
        y = new double[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x[i] = Double.parseDouble(st.nextToken());
            y[i] = Double.parseDouble(st.nextToken());
        }

        x[N] = x[0];
        y[N] = y[0];

        System.out.printf("%.1f", calculate());
    }

    static double calculate() {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += x[i] * y[i + 1];
            sum -= x[i + 1] * y[i];
        }

        return Math.abs(sum / 2);
    }
}
