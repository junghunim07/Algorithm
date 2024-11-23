import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int[] distance;
    static int[] gasStation;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        distance = new int[n - 1];
        gasStation = new int[n];

        String[] str = br.readLine().split(" ");
        for (int i = 0; i < n - 1; i++) {
            distance[i] = Integer.parseInt(str[i]);
        }

        str = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            gasStation[i] = Integer.parseInt(str[i]);
        }

        System.out.println(solve());
    }

    static long solve() {
        long pay = 0;
        int minCost = gasStation[0];

        for (int i = 0; i < distance.length; i++) {
            if (gasStation[i] < minCost) {
                minCost = gasStation[i];
            }

            pay += (long) distance[i] * minCost;
        }

        return pay;
    }
}