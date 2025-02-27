import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int goal;
    int cost;

    Node(int goal, int cost) {
        this.goal = goal;
        this.cost = cost;
    }
}

public class Main {

    static int N, max, nodeNumber;
    static ArrayList<Node>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int flag = Integer.parseInt(st.nextToken());

            while (true) {
                int goal = Integer.parseInt(st.nextToken());
                if (goal == -1) {
                    break;
                }
                int cost = Integer.parseInt(st.nextToken());
                graph[flag].add(new Node(goal, cost));
            }
        }

        visited = new boolean[N + 1];
        dfs(1, 0);

        visited = new boolean[N + 1];
        dfs(nodeNumber, 0);

        System.out.println(max);
    }

    static void dfs(int number, int length) {
        if (length > max) {
            max = length;
            nodeNumber = number;
        }

        visited[number] = true;

        for (int i = 0; i < graph[number].size(); i++) {
            Node node = graph[number].get(i);

            if (!visited[node.goal]) {
                dfs(node.goal, node.cost + length);
            }
        }
    }
}
