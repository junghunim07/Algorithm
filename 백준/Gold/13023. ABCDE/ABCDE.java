import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static boolean isCheck;
    static boolean[] visited;
    static ArrayList<Integer>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        list = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        isCheck = false;

        for(int i=0; i<n; i++) {
            visited = new boolean[n];

            dfs(i,1);

            if(isCheck) {
                System.out.println(1);
                return;
            }
        }
        System.out.println(0);
    }

    static void dfs(int now, int count) {
        if (count == 5) {
            isCheck = true;
            return;
        }

        visited[now] = true;

        for (int next : list[now]) {
            if (!visited[next]) {
                dfs(next, count+1);
            }
        }

        visited[now] = false;
    }
}
