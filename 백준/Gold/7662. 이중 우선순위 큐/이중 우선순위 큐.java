import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int count = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int j = 0; j < count; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                if (st.nextToken().equals("I")) {
                    int number = Integer.parseInt(st.nextToken());
                    map.put(number, map.getOrDefault(number, 0) + 1);
                } else {
                    if (map.size() == 0)
                        continue;

                    int type = Integer.parseInt(st.nextToken());
                    int number;

                    if (type == 1)
                        number = map.lastKey();
                    else
                        number = map.firstKey();

                    if (map.put(number, map.get(number) - 1) == 1) {
                        map.remove(number);
                    }
                }
            }

            if (map.size() == 0) {
                System.out.println("EMPTY");
            } else {
                System.out.println(map.lastKey() + " " + map.firstKey());
            }
        }
    }
}
