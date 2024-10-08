import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static class Robot {
        int x;
        int y;
        int d;
        int count;
        boolean flag;

        Robot(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
            count = 0;
            flag = true;
        }

        public boolean forwardIsBlank(int x, int y) {
            if (map[x][y] == 0)
                return true;

            return false;
        }

        public void go() {
            x = x + dx[d];
            y = y + dy[d];
        }

        public boolean check() {
            if (map[x][y] == 0 && !visited[x][y])
                return true;

            return false;
        }

        public boolean search() {
            for (int i = 0; i < 4; i++) {
                int tmpX = x + dx[i];
                int tmpY = y + dy[i];

                if (forwardIsBlank(tmpX, tmpY) && !visited[tmpX][tmpY])
                    return true;
            }
            return false;
        }

        public void cleaning() {
            if (map[x][y] == 0 && !visited[x][y]) {
                count++;
                visited[x][y] = true;
            }
        }

        public boolean notCleaning() {
            int moveX = x + dx[d];
            int moveY = y + dy[d];

            if (forwardIsBlank(moveX, moveY) && !visited[moveX][moveY])
                return true;

            return false;
        }

        private boolean backIsWall() {
            if (map[x - dx[d]][y - dy[d]] == 1)
                return true;

            return false;
        }

        public void back() {
            x = x - dx[d];
            y = y - dy[d];
        }

        public void turn() {
            d = (d + 3) % 4;
        }

        public void stop() {
            flag = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M];

        st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        Robot robot = new Robot(x, y, d);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (robot.flag) {
            if (robot.check()) {
                robot.cleaning();
            }

            if (!robot.search()) {
                if (!robot.backIsWall()) {
                    robot.back();
                    continue;
                }

                robot.stop();
            }

            if (robot.search()) {
                for (int i = 0; i < 4; i++) {
                    robot.turn();

                    if (robot.notCleaning()) {
                        robot.go();
                        break;
                    }
                }
            }
        }

        System.out.println(robot.count);
    }
}
