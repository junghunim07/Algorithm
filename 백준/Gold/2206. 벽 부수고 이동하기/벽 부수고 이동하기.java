import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Loc {
        int x;
        int y;
        int cnt;
        boolean destroyed;

        public Loc(int x, int y, int cnt, boolean destroyed) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
            this.destroyed = destroyed;
        }
    }

    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][][] visited; // 벽을 부수지 않는 경우 0, 벽을 부순 경우 1

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs(0, 0));
    }

    static int bfs(int x, int y) {
        Queue<Loc> queue = new LinkedList<>();
        queue.add(new Loc(x, y, 1, false));

        while (!queue.isEmpty()) {
            Loc cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.cnt;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) {
                    continue;
                }

                if (map[nx][ny] == '0') {
                    if (!cur.destroyed && !visited[nx][ny][0]) {
                        queue.add(new Loc(nx, ny, cur.cnt + 1, false));
                        visited[nx][ny][0] = true;
                    } else if (cur.destroyed && !visited[nx][ny][1]) {
                        queue.add(new Loc(nx, ny, cur.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                } else if (map[nx][ny] == '1') {

                    if (!cur.destroyed) {
                        queue.add(new Loc(nx, ny, cur.cnt + 1, true));
                        visited[nx][ny][1] = true;
                    }
                }
            }
        }

        return -1;
    }
}
