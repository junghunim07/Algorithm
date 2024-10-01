import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int RED = 1;
    static final int BLUE = -1;
    static boolean check;
    static ArrayList<Integer>[] list;
    static int[] colors;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int K = Integer.parseInt(br.readLine());

        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            list = new ArrayList[V + 1];
            colors = new int[V + 1];
            check = true;

            for (int j = 1; j <= V; j++) {
                list[j] = new ArrayList<>();
            }

            for (int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                list[a].add(b);
                list[b].add(a);
            }

            for (int j = 1; j <= V; j++) {
                if (!check) {
                    break;
                }

                if (colors[j] == 0) {
                    bfs(j, RED);
                }
            }

            if (check) {
                sb.append("YES" + "\n");
            } else {
                sb.append("NO" + "\n");
            }
        }

        System.out.println(sb);
    }

    static void bfs(int startV, int color) {
        Queue<Integer> queue = new LinkedList<>();

        queue.offer(startV);
        colors[startV] = color;

        while (!queue.isEmpty() && check) {
            int v = queue.poll();

            for (int nextV : list[v]) {
                if (colors[nextV] == 0) {
                    queue.add(nextV);
                    colors[nextV] = colors[v] * (-1);
                } else if (colors[v] + colors[nextV] != 0) {
                    check = false;
                    return;
                }
            }
        }
    }
}
