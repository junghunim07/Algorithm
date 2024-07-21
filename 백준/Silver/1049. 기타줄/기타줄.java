import java.util.*;

public class Main {
    static int packageCount = 6;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] packagePrice = new int[m];
        int[] eachPrice = new int[m];

        for (int i = 0; i < m; i++) {
            packagePrice[i] = sc.nextInt();
            eachPrice[i] = sc.nextInt();
        }

        Arrays.sort(packagePrice);
        Arrays.sort(eachPrice);

        if (n < packageCount) {
            System.out.println(Math.min(eachPrice[0] * n, packagePrice[0]));
        } else {
            if (eachPrice[0] * packageCount < packagePrice[0]) {
                System.out.println(eachPrice[0] * n);
            } else {
                int answer = 0;

                while(n > packageCount) {
                    answer += packagePrice[0];
                    n -= packageCount;
                }

                answer += Math.min(eachPrice[0] * n, packagePrice[0]);

                System.out.println(answer);
            }
        }
    }
}