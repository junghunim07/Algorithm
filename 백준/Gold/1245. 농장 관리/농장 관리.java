import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int M, N, count, topHeight;
    static boolean flag;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, -1, -1, 1, 1};
    static int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        visited = new boolean[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    flag = true;
                    dfs(j, i);

                    if (flag)
                        count++;
                }
            }
        }

        System.out.println(count);
    }

    static void dfs(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M)
                continue;

            if (map[moveY][moveX] > map[y][x])
                flag = false;

            if (!visited[moveY][moveX] && map[moveY][moveX] == map[y][x])
                dfs(moveX, moveY);
        }
    }
}
