import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static List<Integer> scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        scores = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            scores.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(scores);

        System.out.println(calculate());
    }

    static long calculate() {
        long sum = 0;
        int count = 1;

        for (Integer score : scores) {
            sum += Math.abs(score - count);
            count++;
        }

        return sum;
    }
}