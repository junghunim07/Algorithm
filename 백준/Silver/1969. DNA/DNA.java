import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, M;
    static String[] DNA;
    static int distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        DNA = new String[N];

        for (int i = 0; i < N; i++) {
            DNA[i] = br.readLine();
        }

        System.out.println(solve());
        System.out.println(distance);
    }

    static StringBuilder solve() {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            int[] count = new int[4];
            for (int j = 0; j < N; j++) {
                char ch = DNA[j].charAt(i);

                switch (ch) {
                    case 'A':
                        count[0]++;
                        break;
                    case 'C':
                        count[1]++;
                        break;
                    case 'G':
                        count[2]++;
                        break;
                    case 'T':
                        count[3]++;
                        break;
                }
            }

            int index = 0;
            int max = 0;

            for (int j = 0; j < 4; j++) {
                if (count[j] > max) {
                    max = count[j];
                    index = j;
                }
            }

            switch (index) {
                case 0:
                    sb.append("A");
                    break;
                case 1:
                    sb.append("C");
                    break;
                case 2:
                    sb.append("G");
                    break;
                case 3:
                    sb.append("T");
                    break;
            }

            distance += N - max;
        }

        return sb;
    }
}