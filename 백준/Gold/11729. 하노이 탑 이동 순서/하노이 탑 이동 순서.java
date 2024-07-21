import java.util.Scanner;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        hanoi(n, 1, 2, 3);
        System.out.println(count);
        System.out.println(sb);
    }

    public static void hanoi(int n, int start, int mid, int to) {
        if (n == 1) {
            sb.append(start + " " + to + "\n");
            count++;
            return;
        }
        hanoi(n - 1, start, to, mid);
        sb.append(start + " " + to + "\n");
        count++;
        hanoi(n - 1, mid, start, to);
    }
}