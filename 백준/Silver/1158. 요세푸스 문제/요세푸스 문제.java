import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        List<Integer> list = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;

        System.out.print("<");

        while(list.size() > 1) {
            if ((index + (K - 1)) < list.size()) {
                index += (K - 1);
            } else {
                index = (index + (K - 1)) % list.size();
            }
            System.out.print(list.get(index) + ", ");
            list.remove(index);
        }

        System.out.println(list.get(0) + ">");
    }
}