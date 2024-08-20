import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int M, N, K, count;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static List<Integer> answer;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        visited = new boolean[M][N];
        answer = new ArrayList<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            drawSquare(x1, y1, x2, y2);
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    count = 0;
                    getArea(j, i);
                    answer.add(count);
                }
            }
        }

        int size = answer.size();

        System.out.println(size);

        Collections.sort(answer);

        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                System.out.print(answer.get(i));
            } else {
                System.out.print(answer.get(i) + " ");
            }
        }
    }

    static void drawSquare(int x1, int y1, int x2, int y2) {
        for (int i = y1; i < y2; i++) {
            for (int j = x1; j < x2; j++) {
                visited[i][j] = true;
            }
        }
    }

    static void getArea(int x, int y) {
        visited[y][x] = true;
        count++;

        for (int i = 0; i < 4; i++) {
            int moveX = x + dx[i];
            int moveY = y + dy[i];

            if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M && !visited[moveY][moveX]) {
                getArea(moveX, moveY);
            }
        }
    }
}
