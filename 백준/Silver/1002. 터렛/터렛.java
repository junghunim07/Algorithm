import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(getMatchingPoint(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
    }

    private static int getMatchingPoint(int x1, int y1, int r1, int x2, int y2, int r2) {
        if (x1 == x2 && y1 == y2 && r1 == r2) {
            return -1;
        }

        double distance = Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2);

        if (distance > Math.pow(r1 + r2, 2)) {
            return 0;
        } else if (distance < Math.pow(r1 - r2, 2)) {
            return 0;
        } else if (distance == Math.pow(r1 + r2, 2)) {
            return 1;
        } else if (distance == Math.pow(r1 - r2, 2)) {
            return 1;
        } else if (distance < Math.pow(r1 + r2, 2)) {
            return 2;
        } else {
            return 2;
        }
    }
}
