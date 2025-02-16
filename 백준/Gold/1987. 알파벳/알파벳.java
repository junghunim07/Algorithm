import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C, max;
    static int[][] board;
    static boolean[] alphabet;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[C][R];
        alphabet = new boolean[26];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                board[j][i] = str.charAt(j) - 'A';
            }
        }

        backTracking(0, 0, 1);
        System.out.println(max);
    }

    static void backTracking(int x, int y, int len) {
        alphabet[board[x][y]] = true;
        max = Math.max(max, len);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                if (!alphabet[board[nx][ny]]) {
                    backTracking(nx, ny, len + 1);
                    alphabet[board[nx][ny]] = false;
                }
            }
        }
    }
}
