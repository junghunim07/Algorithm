import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static char[][] map;
    public static void main(String[] args) throws IOException {
        Scanner sc= new Scanner(System.in);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
        int answer = 1;
        map = new char[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 1; i + k < n && j + k < m; k++) {
                    if (map[i][j] == map[i + k][j] && map[i][j] == map[i][j + k]
                            && map[i][j] == map[i + k][j + k]) {
                        answer = Math.max(answer, (k + 1) * (k + 1));
                    }
                }
            }
        }

        System.out.println(answer);
    }
}