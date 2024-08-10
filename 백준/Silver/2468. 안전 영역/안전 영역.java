import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, minHigh, maxHigh, maxCount;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        minHigh = Integer.MAX_VALUE;
        maxHigh = Integer.MIN_VALUE;
        maxCount = Integer.MIN_VALUE;
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (minHigh > map[i][j]) {
                    minHigh = map[i][j];
                }

                if (maxHigh < map[i][j]) {
                    maxHigh = map[i][j];
                }
            }
        }

        if (minHigh == maxHigh) {
            System.out.println(1);
        } else {
            for (int i = minHigh; i <= maxHigh; i++) {
                visited = new boolean[N][N];
                check(i);
                count();
            }

            System.out.println(maxCount);
        }
    }

    static void check(int rainHeight) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] <= rainHeight) {
                    visited[i][j] = true;
                }
            }
        }
    }

    static void count() {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j);
                    count++;
                }
            }
        }

        if (count > maxCount) {
            maxCount = count;
        }
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && !visited[moveX][moveY]) {
                DFS(moveX, moveY);
            }
        }
    }
}
