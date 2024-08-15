import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int normal, redGreen, n;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n ; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    normalPerson(i, j, map[i][j]);
                    normal++;
                }
            }
        }

        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    redGreenPerson(i, j, map[i][j]);
                    redGreen++;
                }
            }
        }

        System.out.println(normal + " " + redGreen);
    }

    static void normalPerson(int x, int y, char nowColor) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n
                    && !visited[moveX][moveY] && map[moveX][moveY] == nowColor) {
                normalPerson(moveX, moveY, nowColor);
            }
        }
    }

    static void redGreenPerson(int x, int y, char nowColor) {
        visited[x][y] = true;

        if (nowColor == 'R' || nowColor == 'G') {
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n
                        && !visited[moveX][moveY]
                        && (map[moveX][moveY] == 'R' || map[moveX][moveY] == 'G')) {
                    redGreenPerson(moveX, moveY, nowColor);
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int moveX = x + dx[i];
                int moveY = y + dy[i];

                if (moveX >= 0 && moveX < n && moveY >= 0 && moveY < n
                        && !visited[moveX][moveY] && map[moveX][moveY] == nowColor) {
                    redGreenPerson(moveX, moveY, nowColor);
                }
            }
        }
    }
}
