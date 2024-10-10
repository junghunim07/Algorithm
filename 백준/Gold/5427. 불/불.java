import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;
    static boolean[][] visited;
    static Queue<Position> fires;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static StringBuilder sb;

    static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = 0;
            int y = 0;

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            fires = new LinkedList<>();

            for (int a = 0; a < M; a++) {
                String str = br.readLine();

                for (int b = 0; b < N; b++) {
                    char c = str.charAt(b);

                    if (c == '@'){
                        x = b;
                        y = a;
                    }
                    if (c == '*')
                        fires.add(new Position(b, a));
                    map[b][a] = c;
                }
            }

            escape(x, y);
        }

        System.out.print(sb);
    }

    static void escape(int x, int y) {
        Queue<Position> queue = new LinkedList<>();
        visited = new boolean[N][M];
        visited[x][y] = true;
        queue.offer(new Position(-1, -1));
        queue.offer(new Position(x, y));
        int time = -1;

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (now.x == -1 && now.y == -1) {
                burn();

                if (!queue.isEmpty())
                    queue.offer(now);

                time++;
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int moveX = now.x + dx[i];
                int moveY = now.y + dy[i];

                if (moveX >= N || moveY >= M || moveX < 0 || moveY < 0) {
                    sb.append(time + 1).append("\n");
                    return;
                }


                if (map[moveX][moveY] == '.' && !visited[moveX][moveY]) {
                    queue.offer(new Position(moveX, moveY));
                    visited[moveX][moveY] = true;
                }
            }
        }

        sb.append("IMPOSSIBLE\n");
    }

    static void burn() {
        int size = fires.size();

        for (int i = 0; i < size; i++) {
            Position fire = fires.poll();

            for (int j = 0; j < 4; j++) {
                int moveX = fire.x + dx[j];
                int moveY = fire.y + dy[j];

                if (moveX >= 0 && moveX < N && moveY >= 0 && moveY < M) {
                    if (map[moveX][moveY] == '.' || map[moveX][moveY] == '@') {
                        fires.offer(new Position(moveX, moveY));
                        map[moveX][moveY] = '*';
                    }
                }
            }
        }
    }
}
