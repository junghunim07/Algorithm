import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        long N = sc.nextLong();
        long answer = 0;
        int index = 0;

        while (N > 0) {
            if ((N % 2) == 1) {
                answer += pow(index);
            }
            index++;
            N /= 2;
        }

        System.out.println(answer);
    }

    private static long pow(int a) {
        long sum = 1;

        for (int i = 0; i < a; i++)
            sum *= 3;

        return sum;
    }
}
