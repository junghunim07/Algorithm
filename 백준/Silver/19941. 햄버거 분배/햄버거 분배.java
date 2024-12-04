import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static char[] map;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = br.readLine().toCharArray();

        for (int i = 0; i < n; i++) {
            if (map[i] == 'P') {
                int index = Math.max(i - k, 0);
                boolean check = false;

                for (int j = index; j < i; j++) {
                    if (map[j] == 'H') {
                        map[j] = 'X';
                        check = true;
                        count++;
                        break;
                    }
                }

                if (!check) {
                    if (i + k >= n) {
                        index = n - 1;
                    } else {
                        index = i + k;
                    }

                    for (int j = i + 1; j <= index; j++) {
                        if (map[j] == 'H') {
                            map[j] = 'X';
                            count++;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(count);
    }
}