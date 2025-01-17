import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[][] map;
    static PriorityQueue<Shark> pq;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static class Shark implements Comparable<Shark> {
        int x;
        int y;
        int distance;

        public Shark(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

        @Override
        public int compareTo(Shark o) {
            if (this.distance != o.distance) {
                return Integer.compare(this.distance, o.distance);
            } else {
                if (this.x == o.x) {
                    return Integer.compare(this.y, o.y);
                } else {
                    return Integer.compare(this.x, o.x);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        StringTokenizer st;
        Queue<Shark> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    map[i][j] = 0;
                    queue.offer(new Shark(i, j, 0));
                }
            }
        }

        bfs(queue, 2);

        int move = 0;
        int cnt = 0;
        int size = 2;

        while (!pq.isEmpty()) {
            Shark shark = pq.poll();
            map[shark.x][shark.y] = 0;
            if (++cnt == size) {
                cnt = 0;
                size++;
            }
            move += shark.distance;
            queue = new LinkedList<>();
            queue.offer(new Shark(shark.x, shark.y, 0));
            bfs(queue, size);
        }
        System.out.println(move);
    }

    private static void bfs(Queue<Shark> queue, int size) {
        pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[N][N];
        while (!queue.isEmpty()) {
            Shark shark = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = shark.x + dx[i];
                int ny = shark.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= N || map[nx][ny] > size || visited[nx][ny]) {
                    continue;
                }

                visited[nx][ny] = true;
                queue.offer(new Shark(nx, ny, shark.distance + 1));

                if (map[nx][ny] != 0 && map[nx][ny] < size) {
                    pq.offer(new Shark(nx, ny, shark.distance + 1));
                }
            }
        }
    }
}
