import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] cows = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cows[i][0] = Integer.parseInt(st.nextToken());
            cows[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(cows, (o1, o2) -> o1[0] - o2[0]);

        int endTime = 0;

        for (int i = 0; i < n; i++) {
            if (endTime < cows[i][0]) {
                endTime = cows[i][0] + cows[i][1];
            } else {
                endTime += cows[i][1];
            }
        }

        System.out.println(endTime);
    }
}