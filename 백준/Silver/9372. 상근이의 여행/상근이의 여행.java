import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, M, result;
    static boolean[] visited;
    static boolean[][] plane;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            result = 0;

            visited = new boolean[N + 1];
            plane = new boolean[N + 1][N + 1];

            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                plane[a][b] = true;
                plane[b][a] = true;
            }

            bfs();
            System.out.println(result);
        }
    }

    static void bfs() {
        Queue<Integer> q = new LinkedList<>();

        q.add(1);
        visited[1] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int i = 1; i <= N; i++) {
                if (plane[cur][i] && !visited[i]) {
                    result++;
                    visited[i] = true;
                    q.add(i);
                }
            }
        }
    }
}
