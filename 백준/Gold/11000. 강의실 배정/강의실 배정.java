import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Lecture implements Comparable<Lecture>{
    int start;
    int end;

    Lecture(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Lecture o) {
        if (this.start == o.start)
            return this.end - o.end;
        else
            return this.start - o.start;
    }
}

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(start, end);
        }

        Arrays.sort(lectures);

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            if (!queue.isEmpty() && queue.peek() <= lectures[i].start) {
                queue.poll();
            }
            queue.offer(lectures[i].end);
        }

        System.out.println(queue.size());
    }
}
