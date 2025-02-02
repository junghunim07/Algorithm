import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;
    int weight;

    public Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static ArrayList<Edge> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();

        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Edge(start, end, weight));
        }

        dist[1] = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Edge now = graph.get(j);
                if (dist[now.start] != Integer.MAX_VALUE &&
                        dist[now.end] > dist[now.start] + now.weight) {
                    dist[now.end] = dist[now.start] + now.weight;
                }
            }
        }

        boolean cycle = false;
        for (int i = 0; i < m; i++) {
            Edge now = graph.get(i);
            if (dist[now.start] != Integer.MAX_VALUE && dist[now.end] > dist[now.start] + now.weight) {
                cycle = true;
            }
        }

        if (cycle) {
            System.out.println("-1");
        } else {
            for (int i = 2; i <= n; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    System.out.println("-1");
                } else {
                    System.out.println(dist[i]);
                }
            }
        }
    }
}
