import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[][] graph;
    static int score;
    static Deque<Integer> candidate;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        graph = new int[n + 1][n + 1];
        candidate = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i != j) {
                    graph[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1) {
                break;
            }

            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            dfs(i);
        }

        getScore();

        System.out.println(score + " " + candidate.size());

        while (!candidate.isEmpty()) {
            System.out.print(candidate.poll() + " ");
        }
    }

    static void dfs(int k) {
        for (int i = 1; i < graph.length; i++) {
            for (int j = 1; j < graph.length; j++) {
                if (graph[i][k] != Integer.MAX_VALUE && graph[k][j] != Integer.MAX_VALUE) {
                    graph[i][j] = Math.min(graph[i][j], graph[i][k] + graph[k][j]);
                }
            }
        }
    }

    static void getScore() {
        int answer = Integer.MAX_VALUE;

        for (int i = 1; i < graph.length; i++) {
            int tmp = 0;
            for (int j = 1; j < graph.length; j++) {
                tmp = Math.max(tmp, graph[i][j]);
            }

            if (answer > tmp) {
                answer = tmp;
                candidate = new LinkedList<>();
                candidate.add(i);
            } else if (answer == tmp) {
                candidate.add(i);
            }
        }

        score = answer;
    }
}
