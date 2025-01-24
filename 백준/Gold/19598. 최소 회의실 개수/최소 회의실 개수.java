import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static Queue<Conference> input;
    static Queue<Conference> schedule;

    static class Conference implements Comparable<Conference> {
        int start;
        int end;

        public Conference(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Conference o) {
            if (this.end == o.end) {
                return Integer.compare(this.start, o.start);
            }
            return Integer.compare(this.end, o.end);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        schedule = new PriorityQueue<>();
        input = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return Integer.compare(o1.end, o2.end);
            }
            return Integer.compare(o1.start, o2.start);
        });

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            input.add(new Conference(start, end));
        }

        batchConference();

        System.out.println(schedule.size());
    }

    static void batchConference() {
        schedule.add(input.poll());

        while (!input.isEmpty()) {
            Conference now = input.poll();

            for (Conference conference : schedule) {
                if (conference.end > now.start) {
                    schedule.add(now);
                    break;
                } else {
                    schedule.remove(conference);
                    schedule.add(now);
                    break;
                }
            }
        }
    }
}
