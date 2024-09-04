import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numbers);

        int answer = 0;

        for (int i = 0; i < n; i++) {
            int target = numbers[i];
            int start = 0;
            int end = n - 1;

            while (start < end) {
                int sum = numbers[start] + numbers[end];

                if (sum == target) {
                    if (start != i && end != i) {
                        answer++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else {
                        end--;
                    }
                } else if (sum < target) {
                    start++;
                } else {
                    end--;
                }
            }
        }

        System.out.println(answer);
    }
}
