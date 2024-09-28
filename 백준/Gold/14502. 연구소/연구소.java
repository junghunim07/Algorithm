import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, max;
    static int[][] original;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        original = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int wallCount) {
        if (wallCount == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (original[i][j] == 0) {
                    original[i][j] = 1;
                    dfs(wallCount + 1);
                    original[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {
        Queue<Virus> queue = new LinkedList<>();
        int[][] copy = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copy[i][j] = original[i][j];

                if (original[i][j] == 2)
                    queue.offer(new Virus(i, j));
            }
        }

        while (!queue.isEmpty()) {
            Virus virus = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = virus.x + dx[i];
                int moveY = virus.y + dy[i];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                    if (copy[moveX][moveY] == 0) {
                        copy[moveX][moveY] = 2;
                        queue.offer(new Virus(moveX, moveY));
                    }
                }
            }
        }

        countSafeZone(copy);
    }

    static void countSafeZone(int[][] map) {
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    count++;
                }
            }
        }

        max = Math.max(max, count);
    }

    static class Virus {
        int x;
        int y;

        Virus(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
