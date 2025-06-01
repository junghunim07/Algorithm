import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main {

    static HashMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new HashMap<>();

        init(br);
        System.out.println(process(getTarget(br)));
    }

    static StringBuilder process(List<Integer> target) {
        StringBuilder sb = new StringBuilder();

        for (Integer i : target) {
            if (map.containsKey(i)) {
                sb.append(map.get(i)).append(" ");
                continue;
            }

            sb.append(0).append(" ");
        }
        return sb;
    }

    static List<Integer> getTarget(BufferedReader br) throws IOException {
        int M = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        List<Integer> target = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            target.add(Integer.parseInt(input[i]));
        }

        return target;
    }

    static void init(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            if (map.containsKey(Integer.parseInt(input[i]))) {
                map.put(Integer.parseInt(input[i]), map.get(Integer.parseInt(input[i])) + 1);
                continue;
            }

            map.put(Integer.parseInt(input[i]), 1);
        }
    }
}
