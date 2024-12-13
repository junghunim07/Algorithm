import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] height;
    static int[] difference;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        height = new int[n];
        difference = new int[n - 1];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            height[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n - 1; i++) {
            difference[i] = height[i + 1] - height[i];
        }
        Arrays.sort(difference);

        int answer = 0;

        for (int i = 0; i < n - k; i++){
            answer += difference[i];
        }

        System.out.println(answer);
    }
}
