import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static int[] parent = new int[100_001];
    static int[] visited = new int[100_001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(N);
        } else {
            bfs();
            System.out.println(visited[K]);

            Stack<Integer> stack = new Stack<>();
            int index = K;

            while (index != N) {
                stack.push(index);
                index = parent[index];
            }

            stack.push(index);
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
        }
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(N);
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int i = 0; i < 3; i++) {
                int next = nextPosition(i, now);

                if (validation(next) && visited[next] == 0) {
                    visited[next] = visited[now] + 1;
                    parent[next] = now;
                    queue.add(next);
                }

                if (parent[K] != 0) {
                    return;
                }
            }
        }
    }

    static boolean validation(int target) {
        return target >= 0 && target <= 100000;
    }

    static int nextPosition(int i, int now) {
        if (i == 0) {
            return now + 1;
        } else if (i == 1) {
            return now - 1;
        }
        return now * 2;
    }
}
