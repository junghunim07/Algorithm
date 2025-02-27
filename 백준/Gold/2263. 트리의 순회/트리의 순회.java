import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N, preIndex;
    static int[] in, pre, post;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        in = new int[N];
        pre = new int[N];
        post = new int[N];

        getInput(new StringTokenizer(br.readLine()), in);
        getInput(new StringTokenizer(br.readLine()), post);

        getPreOrder(0, N - 1, 0, N - 1);

        for (int i : pre) {
            System.out.print(i + " ");
        }
    }

    static void getPreOrder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart <= inEnd && postStart <= postEnd) {
            pre[preIndex++] = post[postEnd];

            int rootPosition = 0;
            for (int i = inStart; i <= inEnd; i++) {
                if (in[i] == post[postEnd]) {
                    rootPosition = i;
                    break;
                }
            }

            getPreOrder(inStart, rootPosition - 1, postStart, postStart + rootPosition - inStart - 1);
            getPreOrder(rootPosition + 1, inEnd, postStart + rootPosition - inStart, postEnd - 1);
        }
    }

    static void getInput(StringTokenizer st, int[] target) {
        for (int i = 0; i < N; i++) {
            target[i] = Integer.parseInt(st.nextToken());
        }
    }
}
