import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    
    static ArrayList<Node>[] map;
    static boolean[] visit;
    static int n;
    static int max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int m = sc.nextInt();
        map = new ArrayList[n];
        visit = new boolean[n];

        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;
            int d = sc.nextInt();

            map[a].add(new Node(b, d));
            map[b].add(new Node(a, d));
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt() - 1;
            int b = sc.nextInt() - 1;

            dfs(a, b, 0);
            System.out.println(max);
            
            max = 0;
            visit = new boolean[n];
        }
    }

    private static void dfs(int start, int end, int dist) {
        if (start == end) {
            max = dist;
            return;
        }

        visit[start] = true;
        for (int i = 0; i < map[start].size(); i++) {
            if (!visit[map[start].get(i).next]) {
                dfs(map[start].get(i).next, end, dist + map[start].get(i).dist);
            }
        }
    }
}

class Node {
    int next;
    int dist;

    public Node(int next, int dist) {
        this.next = next;
        this.dist = dist;
    }
}
