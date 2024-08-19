import java.util.Scanner;

public class Main {

    static int m;
    static int[] score;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            m = sc.nextInt();
            score = new int[m + 1];

            for (int j = 0; j < m; j++) {
                int a = sc.nextInt();
                int b = sc.nextInt();

                score[a] = b;
            }
            
            System.out.println(getMaxWorker(score[1]));
        }
    }

    static int getMaxWorker(int standard) {
        int count = 1;

        for (int j = 2; j <= m; j++) {
            if (score[j] < standard) {
                standard = score[j];
                count++;
            }
        }

        return count;
    }
}
