import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static int l, nightX, nightY, posX, posY;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -2, -2, -1, 1, 2, 2, 1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            l = sc.nextInt();
            map = new int[l][l];
            visited = new boolean[l][l];
            nightX = sc.nextInt();
            nightY = sc.nextInt();
            posX = sc.nextInt();
            posY = sc.nextInt();

            BFS();

            System.out.println(map[posX][posY]);
        }
    }

    static void BFS() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{nightX, nightY});
        visited[nightX][nightY] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();

            for (int i = 0; i < 8; i++) {
                int moveX = now[0] + dx[i];
                int moveY = now[1] + dy[i];

                if (moveX >= 0 && moveX < l
                        && moveY >= 0 && moveY < l && !visited[moveX][moveY]) {
                    queue.add(new int[]{moveX, moveY});
                    map[moveX][moveY] = map[now[0]][now[1]] + 1;
                    visited[moveX][moveY] = true;
                }
            }
        }
    }
}
