import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Integer[] days = new Integer[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        days[0] = 0;

        for (int i = 1; i <= n; i++) {
            days[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(days, Collections.reverseOrder());

        int max = 0;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, days[i] + i + 1);
        }

        System.out.println(max + 1);
    }
}