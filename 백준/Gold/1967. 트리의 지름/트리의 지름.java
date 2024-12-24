import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Node {
    int end;
    int weight;

    Node(int end, int weight) {
        this.end = end;
        this.weight = weight;
    }
}

public class Main {

    static int N, MAX;
    static boolean[] visited;
    static List<Node>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        list = new List[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, c));
            list[b].add(new Node(a, c));
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            DFS(i, 0);
        }

        System.out.println(MAX);
    }

    static void DFS(int num, int sum) {
        visited[num] = true;
        MAX = Math.max(MAX, sum);
        for (Node node : list[num]) {
            if (!visited[node.end]) {
                DFS(node.end, sum + node.weight);
            }
        }
    }
}
