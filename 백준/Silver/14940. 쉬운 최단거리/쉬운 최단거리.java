import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map, distance;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int startX = 0;
        int startY = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    startX = i;
                    startY = j;
                } else if (map[i][j] == 0) {
                    visited[i][j] = true;
                }
            }
        }

        bfs(startX, startY);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j])
                    distance[i][j] = -1;
                System.out.print(distance[i][j] + " ");
            }

            System.out.println();
        }
    }

    static void bfs(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + dx[i];
                int moveY = now.y + dy[i];

                if (moveX < 0 || moveX >= N || moveY < 0 || moveY >= M)
                    continue;
                if (!visited[moveX][moveY] && map[moveX][moveY] == 1) {
                    visited[moveX][moveY] = true;
                    distance[moveX][moveY] = distance[now.x][now.y] + 1;
                    queue.add(new Position(moveX, moveY));
                }
            }
        }
    }

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
