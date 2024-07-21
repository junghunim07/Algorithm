import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        int[] a = new int[n];
        int[] sortA = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sortA[i] = a[i];
        }
        Arrays.sort(sortA);

        for (int i = 0; i < sortA.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if (sortA[i] == a[j]) {
                    b[j] = i;
                    a[j] = -1;
                    break;
                }
            }
        }

        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }
}