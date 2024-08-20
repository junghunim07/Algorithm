import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n + 1][n + 1];

        for (int i = 1; i <= n ; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        searchPath();
    }

    static void searchPath() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (map[i][k] == 1 && map[k][j] == 1) {
                        map[i][j] = 1;
                    }

                    if (map[j][k] == 1 && map[k][i] == 1) {
                        map[j][i] = 1;
                    }
                }
            }
        }
        printResult();
    }

    static void printResult() {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j == n) {
                    System.out.print(map[i][j]);
                } else {
                    System.out.print(map[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
