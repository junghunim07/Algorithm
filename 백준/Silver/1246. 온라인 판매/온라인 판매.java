import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int maxPrice, answer;
    static int[] lamp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //계란 수
        int m = sc.nextInt(); //고객 수
        int[] price = new int[m];
        int[] sum = new int[n];

        for (int i = 0; i < m; i++) {
            price[i] = sc.nextInt();
        }

        Arrays.sort(price);

        for (int i = 0; i < m; i++) {
            int tmp = price[i];
            int tmpSum = 0;

            if (m - i < n) {
                tmpSum = tmp * (m - i);
            } else {
                tmpSum = tmp * n;
            }

            if (tmpSum > answer) {
                maxPrice = tmp;
                answer = tmpSum;
            }
        }

        System.out.println(maxPrice + " " + answer);
    }
}
