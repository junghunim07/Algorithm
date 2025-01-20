import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int min = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Point {
        int x;
        int y;
        int num;

        public Point(int x, int y, int num) {
            this.x = x;
            this.y = y;
            this.num = num;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int number = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    dfs(i, j, number++);
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] > 1) {
                    bfs(i, j , map[i][j]);
                }
            }
        }

        System.out.println(min);
    }

    static void bfs(int y, int x, int number) {
        Queue<Point> q = new LinkedList<>();
        visited = new boolean[N][N];
        visited[y][x] = true;
        q.add(new Point(x, y, 0));

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int nowX = cur.x;
            int nowY = cur.y;
            int count = cur.num;

            if (map[nowY][nowX] != 0 && map[nowY][nowX] != number) {
                min = Math.min(min, count - 1);
            }

            if (count > min) {
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nx = nowX + dx[i];
                int ny = nowY + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }

                if (map[ny][nx] == number) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                q.add(new Point(nx, ny, count + 1));
                visited[ny][nx] = true;
            }
        }
    }

    static void dfs(int y, int x, int number) {
        visited[y][x] = true;
        map[y][x] = number;
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                continue;
            }
            if (visited[ny][nx] || map[ny][nx] != 1) {
                continue;
            }
            dfs(ny, nx, number);
        }
    }
}
