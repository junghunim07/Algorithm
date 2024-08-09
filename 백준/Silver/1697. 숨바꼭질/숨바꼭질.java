import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
        } else {
            BFS(N);
        }
    }

    static void BFS(int position) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(position);
        visited[position] = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = now;

                if (i == 0)
                    next -= 1;
                if (i == 1)
                    next += 1;
                if (i == 2)
                    next *= 2;

                if (next == K) {
                    System.out.println(visited[now]);
                    return;
                }

                if (next >= 0 && next < visited.length && visited[next] == 0) {
                    queue.add(next);
                    visited[next] = visited[now] + 1;
                }
            }
        }
    }
}
