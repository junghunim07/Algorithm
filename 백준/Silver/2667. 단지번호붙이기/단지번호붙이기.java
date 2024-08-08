import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    static int count, N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        count = 1;

        map = new int[N][N];
        visited = new boolean[N][N];
        result = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    DFS(i, j);
                    result.add(count);
                    count = 1;
                }
            }
        }

        Collections.sort(result);

        System.out.println(result.size());

        for (Integer cnt : result) {
            System.out.println(cnt);
        }
    }

    static void DFS(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && !visited[moveX][moveY] && map[moveX][moveY] == 1) {
                count++;
                DFS(moveX, moveY);
            }
        }
    }
}
