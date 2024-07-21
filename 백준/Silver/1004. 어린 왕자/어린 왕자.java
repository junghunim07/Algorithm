import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();
            int n = sc.nextInt();
            int cnt = 0;

            for (int j = 0; j < n; j++) {
                cnt += getAnswer(x1, y1, x2, y2, sc.nextInt(), sc.nextInt(), sc.nextInt());
            }

            System.out.println(cnt);
        }
    }

    private static int getAnswer(int x1, int y1, int x2, int y2, int x3, int y3, int r) {
        double distance1 = Math.pow(x1 - x3, 2) + Math.pow(y1 - y3, 2);
        double distance2 = Math.pow(x2 - x3, 2) + Math.pow(y2 - y3 , 2);

        if (x1 == x3 && y1 == y3 && distance1 > Math.pow(r, 2)) {
            return 1;
        }
        
        if (x2 == x3 && y2 == y3 && distance2 > Math.pow(r, 2)) {
            return 1;
        }

        if (distance2 <= Math.pow(r, 2) && distance1 > Math.pow(r, 2)) {
            return 1;
        }

        if (distance1 <= Math.pow(r, 2) && distance2 > Math.pow(r, 2)) {
            return 1;
        }

        return 0;
    }
}
