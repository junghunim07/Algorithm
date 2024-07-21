import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int X = sc.nextInt();
        int[] bit = new int[7];

        for (int i = (bit.length-1); i >= 0; i--) {
            if (X > (int) Math.pow(2, i)) {
                X -= (int) Math.pow(2, i);
                bit[i] = 1;
                continue;
            }
            if (X == (int) Math.pow(2, i)) {
                bit[i] = 1;
                break;
            }
        }

        int count = 0;
        for (int i = 0; i < bit.length; i++) {
            if (bit[i] == 1) {
                count++;
            }
        }

        System.out.println(count);
    }
}