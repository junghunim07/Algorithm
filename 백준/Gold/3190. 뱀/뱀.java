import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Command {
    int time;
    char direction;

    Command(int time, char direction) {
        this.time = time;
        this.direction = direction;
    }
}

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int length = 1;
    static int N, answer;
    static int[][] board;
    static Queue<Command> commands;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());

        board = new int[N][N];
        commands = new LinkedList<>();

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            board[x][y] = 1;
        }

        int l = Integer.parseInt(br.readLine());

        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int time = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            commands.add(new Command(time, direction));
        }

        play(0, 0, 1);

        System.out.println(answer);
    }

    static void play(int x, int y, int dir) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        board[x][y] = -1;

        while (true) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            answer++;

            if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                break;
            }

            if (board[nx][ny] == -1) {
                break;
            }

            if (board[nx][ny] == 0) {
                Node node = q.poll();
                board[node.x][node.y] = 0;
            }

            if (!commands.isEmpty()) {
                if (answer == commands.peek().time) {
                    Command command = commands.poll();

                    if (command.direction == 'D') {
                        dir = dir + 1 > 3 ? 0 : dir + 1;
                    }
                    if (command.direction == 'L') {
                        dir = dir - 1 < 0 ? 3 : dir - 1;
                    }
                }
            }

            board[nx][ny] = -1;
            q.offer(new Node(nx, ny));
            x = nx;
            y = ny;
        }
    }
}
