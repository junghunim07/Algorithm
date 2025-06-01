import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Main {

    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        set = new HashSet<>();

        init(br);
        System.out.println(process(getList(br)));;
    }

    static StringBuilder process(List<Integer> target) {
        StringBuilder sb = new StringBuilder();

        for (Integer i : target) {
            if (set.contains(i)) {
                sb.append(1).append(" ");
                continue;
            }
            sb.append(0).append(" ");
        }
        return sb;
    }

    static List<Integer> getList(BufferedReader br) throws IOException {
        List<Integer> target = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < M; i++) {
            target.add(Integer.parseInt(input[i]));
        }
        return target;
    }

    static void init(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(input[i]));
        }
    }
}
