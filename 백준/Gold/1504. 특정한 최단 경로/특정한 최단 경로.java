import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}

public class Main {

    static final int INF = 200_000_000;
    static int N, E, V1, V2;
    static int[] distance;
    static boolean[] visited;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        distance = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        Arrays.fill(distance, INF);

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());

        V1 = Integer.parseInt(st.nextToken());
        V2 = Integer.parseInt(st.nextToken());

        int first = 0;

        first += dijkstra(1, V1);
        first += dijkstra(V1, V2);
        first += dijkstra(V2, N);

        int second = 0;

        second += dijkstra(1, V2);
        second += dijkstra(V2, V1);
        second += dijkstra(V1, N);

        if (first >= INF && second >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(first, second));
        }
    }

    static int dijkstra(int start, int end) {
        Arrays.fill(distance, INF);
        Arrays.fill(visited, false);

        PriorityQueue<Node> pq = new PriorityQueue<>();

        pq.add(new Node(start, 0));
        distance[start] = 0;

        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int cur = curNode.end;

            if (!visited[cur]) {
                visited[cur] = true;

                for (Node node : list[cur]) {
                    if (distance[node.end] > curNode.weight + node.weight) {
                        distance[node.end] = curNode.weight + node.weight;
                        pq.add(new Node(node.end, distance[node.end]));
                    }
                }
            }
        }
        return distance[end];
    }
}
