import java.io.*;
import java.util.*;

public class Main {

    static int[] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        map = new int[101];

        for (int i = 1; i < map.length; i++) {
            map[i] = i;
        }

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x] = y;
        }

        System.out.println(bfs(1));
    }

    static int bfs(int start) {
        int[] check = new int[101];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        check[start] = 0;

        while (true) {
            int visited = queue.poll();

            for (int i = 1; i <= 6; i++) {
                int newNum = visited + i;

                if (newNum > 100) {
                    continue;
                }

                if (check[map[newNum]] == 0) {
                    queue.offer(map[newNum]);
                    check[map[newNum]] = check[visited] + 1;
                }

                if (map[newNum] == 100) {
                    return check[newNum];
                }
            }
        }
    }
}
