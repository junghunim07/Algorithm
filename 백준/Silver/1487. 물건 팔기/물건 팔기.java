import java.util.*;

public class Main {
    static int[][] people;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int price = 0;
        int nowProfit = 0;
        int N = sc.nextInt();
        people = new int[N][2];

        for (int i = 0; i < N; i++) {
            people[i][0] = sc.nextInt();
            people[i][1] = sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            int profit = calculateProfit(people[i][0]);
            if (profit > nowProfit) {
                nowProfit = profit;
                price = people[i][0];
            } else if (profit == nowProfit) {
                if (price > people[i][0]) {
                    price = people[i][0];
                }
            }
        }

        System.out.println(price);
    }

    private static int calculateProfit(int nowPrice) {
        int profit = 0;

        for (int i = 0; i < people.length; i++) {
            if (nowPrice <= people[i][0]) {
                if (nowPrice - people[i][1] > 0) {
                    profit += (nowPrice - people[i][1]);
                }
            }
        }

        return profit;
    }
}
