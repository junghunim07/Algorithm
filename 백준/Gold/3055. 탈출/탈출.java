import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int R, C;
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nowX = 0;
        int nowY = 0;

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'S') {
                    nowX = i;
                    nowY = j;
                }
            }
        }

        printResult(nowX, nowY);
    }

    static int bfs(int nowX, int nowY) {
        Queue<Position> queue = init(nowX, nowY);

        int[][] count = new int[R][C];
        count[nowX][nowY] = 1;

        while (!queue.isEmpty()) {
            Position pos = queue.poll();
            char now = map[pos.x][pos.y];

            for (int i = 0; i < 4; i++) {
                int moveX = pos.x + dx[i];
                int moveY = pos.y + dy[i];

                if (notValidateInRange(moveX, moveY)) {
                    continue;
                }

                if (now == 'S') {
                    if (map[moveX][moveY] == 'D') {
                        return count[pos.x][pos.y];
                    }
                    if (map[moveX][moveY] == '.') {
                        map[moveX][moveY] = 'S';
                        queue.add(new Position(moveX, moveY));
                        count[moveX][moveY] = count[pos.x][pos.y] + 1;
                    }
                }

                if (now == '*') {
                    if (map[moveX][moveY] == '.' || map[moveX][moveY] == 'S') {
                        map[moveX][moveY] = '*';
                        queue.add(new Position(moveX, moveY));
                    }
                }
            }
        }
        return -1;
    }

    static boolean notValidateInRange(int moveX, int moveY) {
        return moveX < 0 || moveX >= R || moveY < 0 || moveY >= C;
    }

    static Queue<Position> init(int nowX, int nowY) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(nowX, nowY));

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == '*') {
                    queue.add(new Position(i, j));
                }
            }
        }

        return queue;
    }

    private static void printResult(int nowX, int nowY) {
        int result = bfs(nowX, nowY);
        if (result == -1) {
            System.out.println("KAKTUS");
            return;
        }
        System.out.println(result);
    }
}
