import java.io.*;
import java.util.*;

class Node {
    int position;
    int time;

    public Node(int position, int time) {
        this.position = position;
        this.time = time;
    }
}

public class Main {

    static int K;
    static boolean[] visited;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new boolean[100001];

        BFS(N);
        System.out.println(min);
    }

    static void BFS(int position) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(position, 0));
        visited[position] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (node.position == K) {
                min = Math.min(min, node.time);
            }

            if (node.position * 2 <= 100000 && !visited[node.position * 2]) {
                queue.offer(new Node(node.position * 2, node.time));
                visited[node.position * 2] = true;
            }

            if (node.position - 1 >= 0 && !visited[node.position - 1]) {
                queue.offer(new Node(node.position - 1, node.time + 1));
                visited[node.position - 1] = true;
            }

            if (node.position + 1 <= 100000 && !visited[node.position + 1]) {
                queue.offer(new Node(node.position + 1, node.time + 1));
                visited[node.position + 1] = true;
            }
        }
    }
}
