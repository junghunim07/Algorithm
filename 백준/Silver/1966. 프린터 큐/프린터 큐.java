import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int tCase = Integer.parseInt(br.readLine());

        for (int i=0; i<tCase; i++) {
            st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> q = new LinkedList<int[]>();

            st = new StringTokenizer(br.readLine());

            for (int j=0; j<N; j++) {
                int num = Integer.parseInt(st.nextToken());

                q.add(new int[] {j, num});
            }

            int cnt = 0;
            while (true) {
                int[] cur = q.poll();
                boolean chk = true;

                for (int[] curQ : q) {
                    if (curQ[1] > cur[1]) {
                        chk = false;
                        break;
                    }
                }

                if (chk) {
                    cnt++;
                    if (cur[0] == M) break;
                } else {
                    q.add(cur);
                }
            }

            System.out.println(cnt);
        }
    }
}