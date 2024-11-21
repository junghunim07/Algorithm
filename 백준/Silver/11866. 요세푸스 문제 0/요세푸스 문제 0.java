import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        sb = new StringBuilder();

        int N = sc.nextInt();
        int K = sc.nextInt();

        sb.append("<");
        solution(N, K);

        System.out.println(sb);
    }

    static void solution(int N, int K) {
        LinkedList<Integer> list = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int index = 0;

        while (list.size() > 1) {
            index = (index + (K - 1)) % list.size();

            sb.append(list.remove(index)).append(", ");
        }

        sb.append(list.remove()).append(">");
    }
}