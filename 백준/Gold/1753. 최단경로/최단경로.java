import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int goal;
    int weight;

    Node(int goal, int weight) {
        this.goal = goal;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {

    static final int INF = Integer.MAX_VALUE;
    static List<Node>[] list;
    static int[] distance;
    static int V, E, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(br.readLine());

        list = new ArrayList[V + 1];
        distance = new int[V + 1];

        Arrays.fill(distance, INF);

        for (int i = 1; i <= V; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            list[start].add(new Node(end, weight));
        }

        StringBuilder sb = new StringBuilder();

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (distance[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(distance[i]).append("\n");
            }
        }

        System.out.println(sb);
    }

    static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[] visited = new boolean[V + 1];
        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node now = pq.poll();
            int cur = now.goal;

            if (visited[cur]) {
                continue;
            }
            visited[cur] = true;
            for (Node node : list[cur]) {
                if (distance[node.goal] > distance[cur] + node.weight) {
                    distance[node.goal] = distance[cur] + node.weight;
                    pq.add(new Node(node.goal, distance[node.goal]));
                }
            }
        }
    }
}
