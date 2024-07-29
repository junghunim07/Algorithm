import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    static int[] numbers;
    static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];

        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(numbers);

        calculateAverage();
        getMedian();
        getMode();
        getRange();
    }

    static void calculateAverage() {
        double sum = 0;

        for (int i = 0; i < N; i++) {
            sum += numbers[i];
        }

        System.out.println(Math.round(sum / N));
    }

    static void getMedian() {
        System.out.println(numbers[N / 2]);
    }

    static void getMode() {
        int[] count = new int[8001];
        int maxFrequency = 0;

        for (int i = 0; i < N; i++) {
            count[numbers[i] + 4000]++;
            maxFrequency = Math.max(count[numbers[i] + 4000], maxFrequency);
        }

        ArrayList<Integer> modeList = new ArrayList<>();

        for (int i = 0; i < count.length; i++) {

            if (maxFrequency == count[i]) {
                modeList.add(i - 4000);
            }
        }

        Collections.sort(modeList);

        if (modeList.size() == 1) {
            System.out.println(modeList.get(0));
        } else {
            System.out.println(modeList.get(1));
        }
    }

    static void getRange() {
        System.out.println(numbers[N - 1] - numbers[0]);
    }
}
