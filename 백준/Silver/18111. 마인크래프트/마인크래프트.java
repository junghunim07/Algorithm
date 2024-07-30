import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, M, B, maxHigh, minHigh, time, high;
    static int[][] map;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        maxHigh = 0;
        minHigh = 256;
        time = Integer.MAX_VALUE;
        high = Integer.MIN_VALUE;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (minHigh > map[i][j])
                    minHigh = map[i][j];
                if (maxHigh < map[i][j])
                    maxHigh = map[i][j];
            }
        }

        for (int i = minHigh; i <= maxHigh; i++) {
            solve(i);
        }

        System.out.println(time + " " + high);
    }

    static void solve(int condition) {
        int block = B;
        int count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (condition < map[i][j]) {
                    count += ((map[i][j] - condition) * 2);
                    block += (map[i][j] - condition);
                } else {
                    block -= (condition - map[i][j]);
                    count += (condition - map[i][j]);
                }
            }
        }

        if(block < 0)
            return;

        if (time >= count) {
            time = count;
            high = condition;
        }
    }
}
