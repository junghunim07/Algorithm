import java.util.*;

public class Main {
    static int N, M, cnt;
    static char[][] room;
    static boolean[][] visited;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt(); //세로 크기
        M = sc.nextInt(); //가로 크기
        sc.nextLine();
        room = new char[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = sc.nextLine();
            for (int j = 0; j < M; j++) {
                room[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!visited[i][j]) {
                    if (room[i][j] == '-') {
                        visitWide(room[i][j], i, j);
                    } else {
                        visitHeight(room[i][j], i, j);
                    }
                    cnt++;
                }
            }
        }

        System.out.println(cnt);
    }

    private static void visitWide(char now, int i, int j) {
        if (now != '-') {
            return;
        }

        visited[i][j] = true;

        if (j + 1 >= M) {
            return;
        }

        visitWide(room[i][j + 1], i, j + 1);
    }

    private static void visitHeight(char now, int i, int j) {
        if (now != '|') {
            return;
        }

        visited[i][j] = true;

        if (i + 1 >= N) {
            return;
        }

        visitHeight(room[i + 1][j], i + 1, j);
    }
}
