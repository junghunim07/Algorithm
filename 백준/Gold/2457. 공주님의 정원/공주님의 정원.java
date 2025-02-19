import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

class Flower implements Comparable<Flower> {
    int start;
    int end;

    Flower(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Flower o) {
        if (this.start == o.start) {
            return o.end - this.end;
        }
        return this.start - o.start;
    }
}

public class Main {

    static int endDay = 1201;
    static int N, count;
    static List<Flower> flowers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        flowers = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());
            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            flowers.add(new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay));
        }

        Collections.sort(flowers);

        System.out.println(solve() >= endDay ? count : 0);
    }

    static int solve() {
        int start = 301;
        int existDay = 0;
        int index = 0;

        while (start < endDay) {
            boolean hasNewFlower = false;

            for (int i = index; i < N; i++) {
                Flower flower = flowers.get(i);

                if (flower.start > start) {
                    break;
                }

                if (flower.end > existDay) {
                    existDay = flower.end;
                    index = i + 1;
                    hasNewFlower = true;
                }
            }

            if (hasNewFlower) {
                start = existDay;
                count++;
            } else {
                break;
            }
        }

        return existDay;
    }
}
