import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int answer = 0;
        boolean[][] paper = new boolean[101][101];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for (int a = x; a < x + 10; a++) {
                for (int b = y; b < y + 10; b++) {
                    if (!paper[a][b]) {
                        paper[a][b] = true;
                        answer++;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
