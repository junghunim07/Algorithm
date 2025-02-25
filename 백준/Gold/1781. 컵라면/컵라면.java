import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Problem implements Comparable<Problem> {
    int deadLine;
    int noodle;

    Problem(int deadLine, int noodle) {
        this.deadLine = deadLine;
        this.noodle = noodle;
    }


    @Override
    public int compareTo(Problem o) {
        if (o.deadLine == this.deadLine) {
            return o.noodle - this.noodle;
        }
        return this.deadLine - o.deadLine;
    }
}

public class Main {

    static ArrayList<Problem> problems;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        problems = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int deadLine = Integer.parseInt(st.nextToken());
            int noodle = Integer.parseInt(st.nextToken());
            problems.add(new Problem(deadLine, noodle));
        }

        Collections.sort(problems);

        System.out.println(solve());
    }

    static long solve() {
        Queue<Integer> pq = new PriorityQueue<>();

        for (Problem problem : problems) {
            pq.add(problem.noodle);

            while (pq.size() > problem.deadLine) {
                pq.poll();
            }
        }

        long total = 0;

        for (Integer count : pq) {
            total += count;
        }
        return total;
    }
}
