import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count, max, nowArea;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    nowArea = 0;
                    DFS(j, i);
                    count++;

                    if (max < nowArea) {
                        max = nowArea;
                    }
                }
            }
        }

        System.out.println(count);
        System.out.println(max);
    }

    static void DFS(int x, int y) {
        visited[y][x] = true;
        nowArea++;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < M && moveY >= 0 && moveY < N
                    && !visited[moveY][moveX] && map[moveY][moveX] == 1) {
                DFS(moveX, moveY);
            }
        }
    }
}
