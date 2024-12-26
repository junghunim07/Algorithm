import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Shore {
        int x;
        int y;
        int distance;

        Shore(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    static int N, M;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 'L') {
                    visited = new boolean[N][M];
                    int value = bfs(i, j);
                    result = Math.max(result, value);
                }
            }
        }

        System.out.println(result);
    }

    static int bfs(int i, int j) {
        Queue<Shore> queue = new LinkedList<>();
        int value = 0;

        visited[i][j] = true;
        queue.add(new Shore(i, j, 0));

        while (!queue.isEmpty()) {
            Shore cur = queue.poll();

            for (int a = 0; a < 4; a++) {
                int nx = cur.x + dx[a];
                int ny = cur.y + dy[a];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M
                        && !visited[nx][ny] && map[nx][ny] == 'L') {
                    visited[nx][ny] = true;
                    queue.add(new Shore(nx, ny, cur.distance + 1));
                    value = Math.max(value, cur.distance + 1);
                }
            }
        }
        return value;
    }
}
