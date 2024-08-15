import java.util.Scanner;

public class Main {

    static int w, h, count;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1, 1, -1, -1, 1};
    static int[] dy = {1, -1, 0, 0, 1, 1, -1, -1};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();
            count = 0;

            if (w == 0 && h == 0) {
                break;
            }

            map = new int[h][w];
            visited = new boolean[h][w];

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    map[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (map[i][j] == 1 && !visited[i][j]) {
                        DFS(j, i);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    static void DFS(int x, int y) {
        visited[y][x] = true;

        for (int i = 0; i < 8; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < w && moveY >= 0 && moveY < h
                    && !visited[moveY][moveX] && map[moveY][moveX] == 1) {
                DFS(moveX, moveY);
            }
        }
    }
}
