import java.util.Scanner;

public class Main {
    static String num;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        num = sc.nextLine();
        int length = num.length();

        if(length % 2 == 1) {
            length -= 1;
            getMaxLength(length);
        } else {
            getMaxLength(length);
        }
    }

    private static void getMaxLength(int length) {
        int left, right;
        int s, e;
        int start, mid, end;

        end = length + 2;

        while (end >= 2) {
            start = 0;
            end -= 2;
            e = end;
            s = start;

            while (e <= num.length()) {
                mid = (s + e) / 2;
                left = 0;
                right = 0;

                for (int i = s; i < mid; i++) {
                    left += Integer.parseInt(String.valueOf(num.charAt(i)));
                }

                for (int i = mid; i < e; i++) {
                    right += Integer.parseInt(String.valueOf(num.charAt(i)));
                }

                if (left == right) {
                    System.out.println(end);
                    return;
                }
                s++;
                e++;
            }
        }

        System.out.println(0);
    }
}
