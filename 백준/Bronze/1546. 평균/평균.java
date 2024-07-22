import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        String[] input = reader.readLine().split(" ");

        float[] score = convertToInt(input, n);

        Arrays.sort(score);

        for (int i = 0; i < n; i++) {
            score[i] = calculateNewScore(score[i], score[n - 1]);
        }

        System.out.println(calculateAverage(score, n));
    }

    public static float[] convertToInt(String[] input, int n) {
        float[] score = new float[n];

        for (int i = 0; i < n; i++) {
            score[i] = Float.parseFloat(input[i]);
        }

        return score;
    }

    public static float calculateAverage(float[] score, int n) {

        float sum = 0;

        for (float v : score) {
            sum += v;
        }

        return sum / n;
    }

    public static float calculateNewScore(float score, float max) {
        return score / max * 100;
    }
}
