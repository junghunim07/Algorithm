import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int V, E;
    static int[][] map;
    static int INF = 987654321;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < V; i++) {
            solution(i);
        }

        System.out.println(answer());
    }

    static int answer() {
        int answer = INF;

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    continue;
                }

                if (existRoute(i, j) && existRoute(j, i)) {
                    answer = Math.min(answer, map[i][j] + map[j][i]);
                }
            }
        }

        return (answer == INF) ? -1 : answer;
    }

    static void solution(int k) {
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i == j) {
                    continue;
                }

                if (map[i][j] > map[i][k] + map[k][j]) {
                    map[i][j] = map[i][k] + map[k][j];
                }
            }
        }
    }

    static boolean existRoute(int i, int j) {
        return map[i][j] != INF;
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V][V];

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (i != j) {
                    map[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            map[a][b] = c;
        }
    }
}
