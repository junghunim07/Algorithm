import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long s = sc.nextLong();
        int count = 1;
        long sum = 0;

        while (true) {
            if (sum + count > s) {
                break;
            }
            sum += count;
            count++;
        }
        System.out.println(count - 1);
    }
}