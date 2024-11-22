import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

class Person {
    int sequence;
    int min;

    Person(int sequence, int min) {
        this.sequence = sequence;
        this.min = min;
    }
}

public class Main {

    static PriorityQueue<Person> pq;
    static int[] answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] strings = br.readLine().split(" ");

        pq = new PriorityQueue<>((p1, p2) -> Integer.compare(p1.min, p2.min));
        answer = new int[n];
        for (int i = 0; i < n; i++) {
            pq.add(new Person(i, Integer.parseInt(strings[i])));
        }

        solve();
        System.out.println(Arrays.stream(answer).sum());
    }

    static void solve() {
        int sum = 0;
        while (!pq.isEmpty()) {
            Person p = pq.poll();
            sum += p.min;
            answer[p.sequence] = sum;
        }
    }
}