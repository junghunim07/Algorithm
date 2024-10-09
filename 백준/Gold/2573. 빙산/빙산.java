import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M, count, year;
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

        while (true) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (map[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j);
                        count++;
                    }
                }
            }

            if (count == 0) {
                break;
            }

            if (count >= 2) {
                break;
            }

            dfs();
            count = 0;
            visited = new boolean[N][M];
        }

        if (count < 2) {
            System.out.println(0);
        } else {
            System.out.println(year);
        }
    }

    //빙산 덩어리
    static void bfs(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M
                    && map[moveX][moveY] > 0 && !visited[moveX][moveY]) {
                bfs(moveX, moveY);
            }
        }
    }

    //매년 빙산 녹이기
    static void dfs() {
        Queue<IceMountain> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0) {
                    queue.offer(new IceMountain(i, j, map[i][j]));
                }
            }
        }

        while (!queue.isEmpty()) {
            IceMountain mountain = queue.poll();

            map[mountain.x][mountain.y] -= countSea(mountain.x, mountain.y);
        }

        year++;
    }

    static int countSea(int x, int y) {
        int count = 0;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (map[moveX][moveY] <= 0 && !visited[moveX][moveY]) {
                count++;
            }
        }

        return count;
    }

    static class IceMountain {
        int x;
        int y;
        int height;

        IceMountain(int x, int y, int height) {
            this.x = x;
            this.y = y;
            this.height = height;
        }
    }
}
