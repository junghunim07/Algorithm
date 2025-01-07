import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int x;
        int y;
        int cost;

        public Node(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static final String format = "Problem %d: ";
    static int N;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int i = 1; true; i++) {
            N = Integer.parseInt(br.readLine());

            if (N == 0) break;

            sb.append(String.format(format, i));
            map = new int[N][N];

            read(br);

            int result = Dijkstra();
            sb.append(result).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int Dijkstra() {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[][] move = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(move[i], Integer.MAX_VALUE);
        }

        pq.add(new Node(0, 0, map[0][0]));
        move[0][0] = map[0][0];

        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            int x = cur.x;
            int y = cur.y;
            int cost = cur.cost;

            if (x == N - 1 && y == N - 1) {
                return cost;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;

                if (cost + map[nx][ny] < move[nx][ny]) {
                    move[nx][ny] = cost + map[nx][ny];
                    pq.add(new Node(nx, ny, cost + map[nx][ny]));
                }
            }
        }
        return -1;
    }

    static void read(BufferedReader br) throws IOException {
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
