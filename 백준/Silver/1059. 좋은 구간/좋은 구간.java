import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int[] S = new int[L];

        for (int i = 0; i < L; i++) {
            S[i] = sc.nextInt();
        }
        Arrays.sort(S);

        int n = sc.nextInt();
        int A = 0;
        int B = 0;
        int answer = 0;

        for (int i = 0; i < S.length; i++) {
            if (S[i] > n && i == 0) {
                A = 1;
                B = S[i] - 1;
                break;
            } else if (S[i] > n) {
                A = S[i - 1] + 1;
                B = S[i] - 1;
                break;
            } else if (S[i] == n) {
                break;
            }
        }

        if (A == 0 && B == 0) {
            answer = 0;
        } else {
            if (A == n || B == n) {
                answer = B - A;
            } else {
                answer += (n - A) + (B - n) + ((n - A) * (B - n));
            }
        }

        System.out.println(answer);
    }
}