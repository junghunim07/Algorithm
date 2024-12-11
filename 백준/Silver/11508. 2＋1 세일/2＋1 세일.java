import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int total = 0;
        Integer[] prices = new Integer[n];

        for (int i = 0; i < n; i++) {
            prices[i] = Integer.parseInt(br.readLine());
            total += prices[i];
        }

        Arrays.sort(prices, Collections.reverseOrder());

        int sale = 0;

        for (int i = 2; i < prices.length; i += 3) {
            sale += prices[i];
        }

        System.out.println(total - sale);
    }
}