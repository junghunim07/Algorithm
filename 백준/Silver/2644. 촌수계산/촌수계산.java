import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] relation;
    static boolean[] checked;
    static int ans = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        relation = new ArrayList[n + 1];
        checked = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            relation[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            relation[a].add(b);
            relation[b].add(a);
        }

        dfs(x, y, 0);
        System.out.println(ans);
    }

    static void dfs(int start, int end, int cnt) {
        if (start == end) {
            ans = cnt;
            return;
        }

        checked[start] = true;
        for (int i = 0; i < relation[start].size(); i++) {
            int next = relation[start].get(i);
            if (!checked[next]) {
                dfs(next, end, cnt + 1);
            }
        }
    }
}
