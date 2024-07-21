import java.util.Scanner;

public class Main {
    final static long MOD = 1_000_000_007;
    static long[][] basicMatrix = {{1, 1}, {1, 0}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long[][] A = {{1, 1}, {1, 0}};
        long N = sc.nextLong();

        System.out.println(pow(A, N-1)[0][0]);
    }

    private static long[][] pow(long[][] A, long N) {
        if (N == 1 || N == 0) {
            return A;
        }

        long[][] ret = pow(A, N / 2);

        ret = multiply(ret, ret);

        if (N % 2 == 1L) {
            ret = multiply(ret, basicMatrix);
        }

        return ret;
    }

    public static long[][] multiply(long[][] o1, long[][] o2) {
        long[][] ret = new long[2][2];

        ret[0][0] = ((o1[0][0] * o2[0][0]) + (o1[0][1] * o2[1][0])) % MOD;
        ret[0][1] = ((o1[0][0] * o2[0][1]) + (o1[0][1] * o2[1][1])) % MOD;
        ret[1][0] = ((o1[1][0] * o2[0][0]) + (o1[1][1] * o2[1][0])) % MOD;
        ret[1][1] = ((o1[1][0] * o2[0][1]) + (o1[1][1] * o2[1][1])) % MOD;

        return ret;
    }
}