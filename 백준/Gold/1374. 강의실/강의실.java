import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture> {
    int num;
    int start;
    int end;

    Lecture(int num, int start, int end) {
        this.num = num;
        this.start = start;
        this.end = end;
    }


    @Override
    public int compareTo(Lecture o) {
        if (this.start == o.start) {
            return this.end - o.end;
        }
        return this.start - o.start;
    }
}

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<Lecture> lectures = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            lectures.add(
                    new Lecture(
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken()),
                            Integer.parseInt(st.nextToken())
                    )
            );
        }

        Collections.sort(lectures);

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int max = 0;

        for (int i = 0; i < n; i++) {
            while (!pq.isEmpty() && pq.peek() <= lectures.get(i).start) {
                pq.poll();
            }

            pq.offer(lectures.get(i).end);
            max = Math.max(max, pq.size());
        }

        System.out.println(max);
    }
}