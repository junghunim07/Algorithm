import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    static int N;
    static int[] graph;
    static boolean[] visited;
    static ArrayList<Integer> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = Integer.parseInt(br.readLine());
        }

        visited = new boolean[N + 1];
        list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }

        Collections.sort(list);

        System.out.println(list.size());
        for (Integer i : list) {
            System.out.println(i);
        }
    }

    static void dfs(int start, int target) {
        if (!visited[graph[start]]) {
            visited[graph[start]] = true;
            dfs(graph[start], target);
            visited[graph[start]] = false;
        }

        if (graph[start] == target)
            list.add(target);
    }
}
