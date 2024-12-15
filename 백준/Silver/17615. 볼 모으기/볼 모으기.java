import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        char[] arr = br.readLine().toCharArray();

        int blueCnt = 0;
        int redCnt = 0;
        int answer = Integer.MAX_VALUE;
        int firstBall = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                redCnt++;
            } else {
                blueCnt++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') {
                firstBall++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, redCnt - firstBall);

        firstBall = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'R') {
                firstBall++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, redCnt - firstBall);

        firstBall = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'B') {
                firstBall++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, blueCnt - firstBall);

        firstBall = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'B') {
                firstBall++;
            } else {
                break;
            }
        }

        answer = Math.min(answer, blueCnt - firstBall);

        System.out.println(answer);
    }
}
