import java.util.Scanner;

public class Main {

    static int count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int M = sc.nextInt();
            int N = sc.nextInt();
            int K = sc.nextInt();

            count = 0;
            map = new int[N][M];
            visited = new boolean[N][M];

            for (int j = 0; j < K; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                map[y][x] = 1;
            }

            for (int a = 0; a < N; a++) {
                for (int b = 0; b < M; b++) {
                    if (!visited[a][b] && map[a][b] == 1) {
                        DFS(a, b, N, M);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void DFS(int x, int y, int N, int M) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && !visited[moveX][moveY] && map[moveX][moveY] == 1) {
                DFS(moveX, moveY, N, M);
            }
        }
    }
}
