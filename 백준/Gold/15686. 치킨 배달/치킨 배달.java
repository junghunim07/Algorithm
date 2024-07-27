import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
    int x;
    int y;

    Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, M;
    static int[][] map;
    static ArrayList<Node> house;
    static ArrayList<Node> chicken;
    static int answer = Integer.MAX_VALUE;
    static boolean[] open;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        house = new ArrayList<>();
        chicken = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 1) {
                    house.add(new Node(i, j));
                } else if (map[i][j] == 2) {
                    chicken.add(new Node(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];
        DFS(0, 0);
        System.out.println(answer);
        br.close();
    }

    static void DFS(int start, int count) {
        if (count == M) {
            int res = 0;

            for (int i = 0; i < house.size(); i++) {
                int tmp = Integer.MAX_VALUE;

                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) {
                        int distance = Math.abs(house.get(i).x - chicken.get(j).x)
                                + Math.abs(house.get(i).y - chicken.get(j).y);

                        tmp = Math.min(tmp, distance);
                    }
                }
                res += tmp;
            }

            answer = Math.min(answer, res);
            return;
        }

        for (int i = start; i < chicken.size(); i++) {
            open[i] = true;
            DFS(i + 1, count + 1);
            open[i] = false;
        }
    }
}
