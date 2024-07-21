import java.util.*;

public class Main {
    static long X, Y, W, S;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        X = sc.nextLong(); //집 위치 x 좌표
        Y = sc.nextLong(); //집 위치 y 좌표
        W = sc.nextLong(); //한 블록가는데 걸리는 시간
        S = sc.nextLong(); //대각선으로 가는데 걸리는 시간

        long tmp1, tmp2, tmp3;

        tmp1 = (X + Y) * W;

        tmp2 = 0;
        if ((X + Y) % 2 == 0) {
            tmp2 = Math.max(X, Y) * S;
        } else {
            tmp2 = (Math.max(X, Y) - 1) * S + W;
        }

        tmp3 = (Math.min(X, Y) * S) + (Math.abs(X - Y) * W);

        System.out.println(Math.min(tmp1, Math.min(tmp2, tmp3)));
    }
}
