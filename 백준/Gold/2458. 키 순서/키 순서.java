import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N; i++) {
            solution(i);
        }

        System.out.println(result());
    }

    static int result() {
        int[] count = new int[N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] || map[j][i]) {
                    count[i]++;
                }
            }
        }
        return getAnswer(count);
    }

    static int getAnswer(int[] count) {
        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (count[i] == N - 1) {
                answer++;
            }
        }
        return answer;
    }

    static void solution(int k) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][k] && map[k][j]) {
                    map[i][j] = true;
                }
            }
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;

            map[a][b] = true;
        }
    }
}
