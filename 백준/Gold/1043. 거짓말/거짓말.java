import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static int N, M; // N : 사람 수, M : 파티 수
    static int[] truth;
    static int[] parent;
    static ArrayList<Integer>[] party;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        int count = sc.nextInt();

        if (count == 0) {
            System.out.println(M);
            return;
        }

        truth = new int[count];
        parent = new int[N + 1];
        party = new ArrayList[M];

        // 진실을 아는 사람
        for (int i = 0; i < count; i++) {
            truth[i] = sc.nextInt();
        }

        // 파티원
        for (int i = 0; i < M; i++) {
            party[i] = new ArrayList<>();
            int member = sc.nextInt();

            for (int j = 0; j < member; j++) {
                party[i].add(sc.nextInt());
            }
        }

        // 부모
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        // 파티원 같은 집합으로 묶기 -> 같은 부모
        for (int i = 0; i < M; i++) {
            int leader = party[i].get(0);

            for (int j = 1; j < party[i].size(); j++) {
                union(leader, party[i].get(j));
            }
        }

        int cnt = 0;

        for (int i = 0; i < M; i++) {
            int leader = party[i].get(0);
            boolean flag = true;

            for (int j = 0; j < count; j++) {
                if (isExist(leader, truth[j])) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                cnt++;
            }
        }

        System.out.println(cnt);
    }

    static boolean isExist(int a, int b) {
        if (find(a) == find(b)) {
            return true;
        }

        return false;
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y) {
            parent[y] = x;
        } else {
            parent[x] = y;
        }
    }

    static int find(int x) {
        if (x == parent[x]) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }
}
