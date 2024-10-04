import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N;
    static Position house, festival;
    static ArrayList<Position> marts;


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
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            marts = new ArrayList<>();
            N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            house = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());

                marts.add(new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
            }

            st = new StringTokenizer(br.readLine());
            festival = new Position(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            if (bfs()) sb.append("happy\n");
            else sb.append("sad\n");
        }

        System.out.println(sb);
    }

    static boolean checkDistance(Position now, Position next) {
        int distance = Math.abs((now.x - next.x)) + Math.abs((now.y - next.y));

        if (distance <= 1000)
            return true;

        return false;
    }

    static boolean bfs() {
        boolean[] visited = new boolean[N];
        Queue<Position> queue = new LinkedList<>();
        queue.offer(house);

        while (!queue.isEmpty()) {
            Position now = queue.poll();

            if (checkDistance(now, festival)) {
                return true;
            }

            for (int i = 0; i < N; i++) {
                Position next = marts.get(i);

                if (!visited[i] && checkDistance(now, next)) {
                    visited[i] = true;
                    queue.add(next);
                }
            }
        }

        return false;
    }
}
