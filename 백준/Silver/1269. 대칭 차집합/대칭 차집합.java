import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];

        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }

        Set<Integer> answer = new HashSet<>();

        for (int i = 0; i < n; i++) {
            answer.add(A[i]);
        }

        for (int i = 0; i < m; i++) {
            if (answer.contains(B[i])) {
                answer.remove(B[i]);
            } else {
                answer.add(B[i]);
            }
        }

        System.out.println(answer.size());
    }
}
