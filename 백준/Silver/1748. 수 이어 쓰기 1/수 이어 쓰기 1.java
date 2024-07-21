import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int totalCount = 0;
        int num = 1;
        int criteria = 10;

        for (int i = 1; i <= n; i++) {
            if (i % criteria == 0) {
                num += 1;
                criteria *= 10;
            }
            totalCount += num;
        }

        System.out.println(totalCount);
    }
}