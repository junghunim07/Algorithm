import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        sc.nextLine();
        Set<String> set = new HashSet<>();
        String[] num = new String[N];

        for (int i = 0; i < N; i++) {
            num[i] = sc.nextLine();
        }

        int len = num[0].length();

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < N; j++) {
                set.add(num[j]. substring(len - i));
            }

            if (set.size() == N) {
                System.out.println(i);
                return;
            }
            set.clear();
        }
    }
}
