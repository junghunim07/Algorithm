import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[] count;
    static boolean[] visited;
    static ArrayList<Integer> answer;
    static ArrayList<Integer>[] trustComputer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        count = new int[N + 1];
        visited = new boolean[N + 1];

        answer = new ArrayList<>();
        trustComputer = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            trustComputer[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            trustComputer[a].add(b);
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            dfs(i);
        }

        int max = 0;

        for (int i = 1; i < count.length; i++) {
            if (max < count[i]) {
                answer.clear();
                max = count[i];
                answer.add(i);
            } else if (max == count[i]) {
                answer.add(i);
            }
        }

        Collections.sort(answer);

        for (Integer i : answer) {
            System.out.print(i + " ");
        }
    }

    static void dfs(int start) {

        if (visited[start])
            return;

        visited[start] = true;

        for (int next : trustComputer[start]) {
            if (visited[next])
                continue;

            count[next] ++;
            dfs(next);
        }
    }
}
