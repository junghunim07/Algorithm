import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Tomato {
    int x;
    int y;
    int z;

    Tomato(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}

public class Main {

    static int M, N, H, date;
    static int[][][] box;
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static Queue<Tomato> queue;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        box = new int[H][N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                for (int k = 0; k < M; k++) {
                    box[i][j][k] = Integer.parseInt(st.nextToken());

                    if (box[i][j][k] == 1) {
                        queue.add(new Tomato(k, j, i));
                    }
                }
            }
        }

        BFS();
        System.out.println(getResult());
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();

            for (int i = 0; i < 6; i++) {
                int moveX = tomato.x + dx[i];
                int moveY = tomato.y + dy[i];
                int moveZ = tomato.z + dz[i];

                if (checkBox(moveX, moveY, moveZ)) {
                    queue.add(new Tomato(moveX, moveY, moveZ));
                    box[moveZ][moveY][moveX] = box[tomato.z][tomato.y][tomato.x] + 1;
                }
            }
        }
    }

    static boolean checkBox(int x, int y, int z) {
        return x >= 0 && x < M && y >= 0 && y < N && z >= 0 && z < H
                && box[z][y][x] == 0;
    }

    static int getResult() {
        int result = Integer.MIN_VALUE;

        for (int z = 0; z < H; z++) {
            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (box[z][y][x] == 0) {
                        return -1;
                    }

                    result = Math.max(result, box[z][y][x]);
                }
            }
        }

        if (result == 1) return 0;
        return result - 1;
    }
}
