import java.util.*;

public class Main {
    static int W, H, X, Y, P;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        W = sc.nextInt();
        H = sc.nextInt();
        X = sc.nextInt();
        Y = sc.nextInt();
        P = sc.nextInt();

        for (int i = 0; i < P; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (checkingSquare(x, y) || checkingRound(x, y)) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    private static boolean checkingSquare(int x, int y) {
        if (x >= X && x <= X + W && y >= Y && y <= Y + H) {
            return true;
        }
        return false;
    }

    private static boolean checkingRound(int x, int y) {
        int r = H / 2;
        if (x < X) {
            int pointX = X;
            int pointY = Y + r;
            if (calculateDistance(x, y, pointX, pointY) <= r) {
                return true;
            }
        } else if (x > X + W) {
            int pointX = X + W;
            int pointY = Y + r;
            if (calculateDistance(x, y, pointX, pointY) <= r) {
                return true;
            }
        }
        return false;
    }

    private static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
