import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            A.add(a);
        }

        Collections.sort(A);

        System.out.println(A.get(0) * A.get(A.size() - 1));
    }
}