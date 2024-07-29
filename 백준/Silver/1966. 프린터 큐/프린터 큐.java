import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int position;
    int important;

    Node(int position, int important) {
        this.position = position;
        this.important = important;
    }
}

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        LinkedList<Node> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                queue.add(new Node(j, Integer.parseInt(st.nextToken())));
            }

            solve(queue, M);
        }
    }

    static void solve(LinkedList<Node> queue, int M) {
        int count = 0;

        while (!queue.isEmpty()) {
            Node front = queue.poll();
            boolean isMax = true;

            for (int i = 0; i < queue.size(); i++) {

                if (front.important < queue.get(i).important) {
                    queue.offer(front);

                    for (int j = 0; j < i; j++) {
                        queue.offer(queue.poll());
                    }

                    isMax = false;
                    break;
                }
            }

            if (!isMax) {
                continue;
            }

            count+=1;

            if (front.position == M) {
                System.out.println(count);
            }
        }
    }
}
