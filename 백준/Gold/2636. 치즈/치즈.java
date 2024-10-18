import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int cheese;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    cheese++;
            }
        }

        int count = 0;
        int time = 0;

        while (cheese != 0) {
            count = cheese;
            time++;
            visited = new boolean[N][M];
            bfs();
        }

        System.out.println(time);
        System.out.println(count);
    }

    static void bfs() {
        Queue<Position> queue = new LinkedList<>();
        queue.offer(new Position(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + dx[i];
                int moveY = now.y + dy[i];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && !visited[moveX][moveY]) {
                    visited[moveX][moveY] = true;

                    if (map[moveX][moveY] == 0)
                        queue.offer(new Position(moveX, moveY));
                    else {
                        cheese--;
                        map[moveX][moveY] = 0;
                    }
                }
            }
        }
    }
}