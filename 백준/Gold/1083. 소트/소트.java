import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, S;
    static int[] array;

    public static void main(String[] args) throws IOException {
        init();

        for (int i = 0; i < N && S > 0; i++) {
            int maxIndex = findMaxValue(i);
            S -= (maxIndex - i);
            change(maxIndex, i);
        }

        print();
    }

    static void print() {
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }
    }

    static int findMaxValue(int start) {
        int max = start;
        for (int i = start + 1; i < N && i <= start + S; i++) {
            if (array[i] > array[max]) {
                max = i;
            }
        }
        return max;
    }

    static void change(int start, int end) {
        for (int i = start; i > end; i--) {
            int tmp = array[i];
            array[i] = array[i - 1];
            array[i - 1] = tmp;
        }
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        array = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        S = Integer.parseInt(br.readLine());
    }
}
