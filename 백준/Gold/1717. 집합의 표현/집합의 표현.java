import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());

            int flag = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (flag == 0) {
                union(a, b);
            } else {
                System.out.println(getAnswer(a, b));
            }
        }

    }

    static String getAnswer(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return "YES";
        return "NO";
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (x > y) arr[x] = y;
            else arr[y] = x;
        }
    }

    static int find(int x) {
        if (x == arr[x]) {
            return x;
        }

        return arr[x] = find(arr[x]);
    }
}
