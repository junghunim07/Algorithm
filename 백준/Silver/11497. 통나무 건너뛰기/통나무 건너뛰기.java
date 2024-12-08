import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] height = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                height[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(height);

            System.out.println(solution(height));
        }
    }

    static int solution(int[] height) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < height.length - 2; i += 2) {
            max = Math.max(max, Math.abs(height[i] - height[i + 2]));
        }

        for (int i = 1; i < height.length - 2; i += 2) {
            max = Math.max(max, Math.abs(height[i] - height[i + 2]));
        }

        max = Math.max(max, Math.abs(height[height.length - 1] - height[height.length - 2]));

        return max;
    }
}