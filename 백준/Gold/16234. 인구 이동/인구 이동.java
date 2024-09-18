import java.io.*;
import java.util.*;

class Node {
    int x;
    int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static ArrayList<Node> list;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        System.out.println(move());
    }

    static int move() {
        int result = 0;

        while (true) {
            boolean isMove = false;
            visited = new boolean[N][N];

            for (int i  = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        int sum = bfs(i, j);

                        if (list.size() > 1) {
                            getAverage(sum);
                            isMove = true;
                        }
                    }
                }
            }

            if (!isMove)
                return result;
            result++;
        }
    }

    static int bfs(int x, int y) {
        Queue<Node> queue = new LinkedList<>();
        list = new ArrayList<>();

        queue.offer(new Node(x, y));
        list.add(new Node(x, y));
        visited[x][y] = true;

        int sum = map[x][y];

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            for (int i = 0; i < 4; i++) {
                int moveX = node.x + dx[i];
                int moveY = node.y + dy[i];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < N && !visited[moveX][moveY]) {
                    int move = Math.abs(map[node.x][node.y] - map[moveX][moveY]);

                    if (move >= L && move <= R) {
                        queue.offer(new Node(moveX, moveY));
                        list.add(new Node(moveX, moveY));
                        sum += map[moveX][moveY];
                        visited[moveX][moveY] = true;
                    }
                }
            }
        }

        return sum;
    }

    static void getAverage(int sum) {
        int avg = sum / list.size();

        for (Node node : list) {
            map[node.x][node.y] = avg;
        }
    }
}
