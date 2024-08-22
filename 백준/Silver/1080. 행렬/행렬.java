import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N, M, count;
    static int[][] A;
    static int[][] B;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = new int[N][M];
        B = new int[N][M];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                A[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                B[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A[i][j] != B[i][j]) {
                    if (check(j, i)) {
                        revers(j, i);
                    } else {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }

    static boolean check(int x, int y) {
        if (x + 3 <= M && y + 3 <= N) {
            return true;
        }

        return false;
    }

    static void revers(int x, int y) {
        for (int i = y; i < (y + 3); i++) {
            for (int j = x; j < (x + 3); j++) {
                if (A[i][j] == 1) {
                    A[i][j] = 0;
                } else {
                    A[i][j] = 1;
                }
            }
        }
        count++;
    }
}
