import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            map[a][b] = 1;
            map[b][a] = 1;
        }

        update();
        System.out.println(getAnswer());
    }

    static void update() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (map[i][j] == 0 && i != j) {
                        if (map[i][k] != 0 && map[k][j] != 0) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    } else if (map[i][j] != 0 && i != j) {
                        if (map[i][k] != 0 && map[k][j] != 0) {
                            map[i][j] = Math.min(map[i][k] + map[k][j], map[i][j]);
                        }
                    }
                }
            }
        }
    }

    static int getAnswer() {
        int min = Integer.MAX_VALUE;
        int answer = 0;

        for (int i = 1; i <= N; i++) {
            int tmp = 0;

            for (int j = 1; j <= N; j++) {
                tmp += map[i][j];
            }

            if (tmp < min) {
                min = tmp;
                answer = i;
            }
        }

        return answer;
    }
}
