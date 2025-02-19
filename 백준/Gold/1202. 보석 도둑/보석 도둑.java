import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Jewel implements Comparable<Jewel> {
    int weight;
    int price;

    Jewel(int weight, int price) {
        this.weight = weight;
        this.price = price;
    }


    @Override
    public int compareTo(Jewel o) {
        return this.weight - o.weight;
    }
}

public class Main {

    static int N; //보석 개수
    static int K; //가방 개수
    static List<Integer> bags;
    static List<Jewel> jewels;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        bags = new ArrayList<>();
        jewels = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int weight = Integer.parseInt(st.nextToken());
            int price = Integer.parseInt(st.nextToken());

            jewels.add(new Jewel(weight, price));
        }

        for (int i = 0; i < K; i++) {
            bags.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(jewels);
        Collections.sort(bags);

        System.out.println(solve());
    }

    static long solve() {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int index = 0;
        long total = 0;

        for (int i = 0; i < K; i++) {
            while (index < N && jewels.get(index).weight <= bags.get(i)) {
                pq.add(jewels.get(index).price);
                index++;
            }

            if (!pq.isEmpty()) {
                total += pq.poll();
            }
        }

        return total;
    }
}
