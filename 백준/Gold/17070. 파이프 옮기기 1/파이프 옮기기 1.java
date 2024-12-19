import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, answer;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        DFS(1, 2, 0);
        System.out.println(answer);
    }

    static void DFS(int row, int col, int direction) {
        if (row > N || col > N || map[row][col] == 1) {
            return;
        }
        if (direction == 2) {
            if (map[row -1][col] == 1 || map[row][col - 1] == 1) {
                return;
            }
        }
        if (row == N && col == N) {
            answer++;
            return;
        }

        switch (direction) {
            case 0:
                DFS(row, col + 1, 0);
                DFS(row + 1, col + 1, 2);
                break;
            case 1:
                DFS(row + 1, col, 1);
                DFS(row + 1, col + 1, 2);
                break;
            case 2:
                DFS(row + 1, col + 1, 2);
                DFS(row + 1, col, 1);
                DFS(row, col + 1, 0);
                break;
        }
    }
}
