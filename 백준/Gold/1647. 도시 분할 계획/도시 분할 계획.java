import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class Node implements Comparable<Node> {
        int from;
        int to;
        int cost;

        public Node(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Node o) {
            return cost - o.cost;
        }
    }

    static int N, M;
    static int[] parents;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parents = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            parents[i] = i;
        }

        System.out.println(kruskal(br));
    }

    static int kruskal(BufferedReader br) throws IOException {
        Queue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            pq.add(new Node(x, y, cost));
        }

        return run(pq);
    }

    static int run(Queue<Node> pq) {
        int total = 0;
        int maxCost = 0;

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (isNotSameParent(cur.from, cur.to)) {
                total += cur.cost;
                union(cur.from, cur.to);
                
                maxCost = cur.cost;
            }
        }
        return total - maxCost;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x <= y) {
            parents[y] = x;
        } else {
            parents[x] = y;
        }
    }

    static int find(int x) {
        if (x == parents[x]) {
            return x;
        }
        return parents[x] = find(parents[x]);
    }

    static boolean isNotSameParent(int x, int y) {
        return find(x) != find(y);
    }
}
