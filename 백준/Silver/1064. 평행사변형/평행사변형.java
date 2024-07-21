import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] x = new int[3];
        int[] y = new int[3];

        for (int i = 0; i < 3; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        if ((x[0] - x[1]) * (y[1] - y[2]) == (x[1] - x[2]) * (y[0] - y[1])) {
            System.out.println(-1.0);
        } else {
            double ab = getLength(x[0], y[0], x[1], y[1]);
            double bc = getLength(x[1], y[1], x[2], y[2]);
            double ac = getLength(x[0], y[0], x[2], y[2]);

            double side1 = (ab + bc) * 2;
            double side2 = (ab + ac) * 2;
            double side3 = (bc + ac) * 2;

            double min = Math.min(side1, side2);
            min = Math.min(min, side3);

            double max = Math.max(side1, side2);
            max = Math.max(max, side3);

            System.out.println(max - min);
        }
    }

    private static double getLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(Math.abs(x1 - x2), 2) + Math.pow(Math.abs(y1 - y2), 2));
    }
}