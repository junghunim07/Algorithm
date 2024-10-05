import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int A, B, C;
    static ArrayList<Integer> answer;

    static class Bottle {
        int a;
        int b;
        int c;

        Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();

        bfs();
        
        Collections.sort(answer);

        for (Integer ans : answer) {
            System.out.print(ans + " ");
        }
    }

    static void bfs() {
        Queue<Bottle> queue = new LinkedList<>();
        boolean[][][] visited = new boolean[A + 1][B + 1][C + 1];

        queue.add(new Bottle(0, 0, C));

        while (!queue.isEmpty()) {
            Bottle bottle = queue.poll();

            if (visited[bottle.a][bottle.b][bottle.c]) {
                continue;
            }

            if (bottle.a == 0) {
                answer.add(bottle.c);
            }

            visited[bottle.a][bottle.b][bottle.c] = true;

            if (bottle.a + bottle.b <= A)
                queue.add(new Bottle(bottle.a + bottle.b, 0, bottle.c));
            else
                queue.add(new Bottle(A, bottle.a + bottle.b - A, bottle.c));

            if (bottle.a + bottle.c <= A)
                queue.add(new Bottle(bottle.a + bottle.c, bottle.b, 0));
            else
                queue.add(new Bottle(A, bottle.b, bottle.a + bottle.c - A));

            if (bottle.a + bottle.b <= B)
                queue.add(new Bottle(0, bottle.a + bottle.b, bottle.c));
            else
                queue.add(new Bottle(bottle.a + bottle.b - B, B, bottle.c));

            if (bottle.b + bottle.c <= B)
                queue.add(new Bottle(bottle.a, bottle.b + bottle.c, 0));
            else
                queue.add(new Bottle(bottle.a, B, bottle.b + bottle.c - B));

            if (bottle.a + bottle.c <= C)
                queue.add(new Bottle(0, bottle.b, bottle.a + bottle.c));
            else
                queue.add(new Bottle(bottle.a + bottle.c - C, bottle.b, C));

            if (bottle.b + bottle.c <= C)
                queue.add(new Bottle(bottle.a, 0, bottle.b + bottle.c));
            else
                queue.add(new Bottle(bottle.a, bottle.b + bottle.c - C, C));
        }
    }
}
