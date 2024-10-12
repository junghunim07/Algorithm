import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int H, W, x, y, K;
    static int[][] map;
    static int[] dice;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        sb = new StringBuilder();

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[W][H];
        dice = new int[6];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < W; j++) {
                map[j][i] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {
            int order = Integer.parseInt(st.nextToken());

            switch (order) {
                case 1:
                    moveRight();
                    break;
                case 2:
                    moveLeft();
                    break;
                case 3:
                    moveUp();
                    break;
                case 4:
                    moveDown();
                    break;
            }
        }

        System.out.println(sb);
    }

    static void moveRight() {
        x++;

        if (x >= W) {
            x--;
            return;
        }

        int tmp = dice[1];

        dice[1] = dice[4];
        dice[4] = dice[3];
        dice[3] = dice[5];
        dice[5] = tmp;

        copy();
    }

    static void moveLeft() {
        x--;

        if (x < 0) {
            x++;
            return;
        }

        int tmp = dice[1];

        dice[1] = dice[5];
        dice[5] = dice[3];
        dice[3] = dice[4];
        dice[4] = tmp;

        copy();
    }

    static void moveUp() {
        y--;

        if (y < 0) {
            y++;
            return;
        }

        int tmp = dice[0];
        dice[0] = dice[1];
        dice[1] = dice[2];
        dice[2] = dice[3];
        dice[3] = tmp;

        copy();
    }

    static void moveDown() {
        y++;

        if (y >= H) {
            y--;
            return;
        }

        int tmp = dice[0];

        dice[0] = dice[3];
        dice[3] = dice[2];
        dice[2] = dice[1];
        dice[1] = tmp;

        copy();
    }

    static void copy() {
        if (map[x][y] == 0) {
            map[x][y] = dice[3];
        } else {
            dice[3] = map[x][y];
            map[x][y] = 0;
        }

        sb.append(dice[1]).append("\n");
    }
}
