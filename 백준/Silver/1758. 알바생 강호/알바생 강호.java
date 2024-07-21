import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Integer[] tip = new Integer[n];
        long maxTip = 0;

        for (int i = 0; i < n; i++) {
            tip[i] = sc.nextInt();
        }

        Arrays.sort(tip, (a, b) ->  b - a);

        for (int i = 0; i < n; i++) {
            if (tip[i] - i < 0) {
                break;
            }
            
            maxTip += tip[i] - i;
        }

        System.out.println(maxTip);
    }
}
