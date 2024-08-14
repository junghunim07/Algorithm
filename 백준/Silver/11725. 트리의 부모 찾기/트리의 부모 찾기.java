import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int[] parentNode;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        parentNode = new int[N + 1];
        visited = new boolean[N + 1];
        list = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(y);
            list[y].add(x);
        }

        DFS(1);

        for (int i = 2; i <= N; i++){
            System.out.println(parentNode[i]);
        }
    }

    static void DFS(int x) {
        visited[x] = true;

        for (int i : list[x]) {
            if (!visited[i]) {
                parentNode[i] = x;
                DFS(i);
            }
        }
    }
}
