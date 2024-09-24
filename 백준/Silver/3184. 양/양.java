import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R,C;
    static int[] count;
    static char[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int wolf = 0;
        int sheep = 0;
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        count = new int[2];
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();

            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (!visited[i][j] && !(map[i][j] == '#')) {
                    count[0] = 0;
                    count[1] = 0;

                    dfs(i, j);

                    if (count[1] >= count[0])
                        wolf += count[1];
                    else
                        sheep += count[0];
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }

    static void dfs(int x, int y) {
        visited[x][y] = true;

        if (map[x][y] == 'o')
            count[0]++;
        if (map[x][y] == 'v')
            count[1]++;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX < 0 || moveX >= R || moveY < 0 || moveY >= C)
                continue;
            if (visited[moveX][moveY] || map[moveX][moveY] == '#')
                continue;

            dfs(moveX, moveY);
        }
    }
}
