import java.io.*;
import java.util.Scanner;

public class Main {

    static int[][] map;
    static boolean[] check;
    static int N, M, count;

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            map[a][b] = map[b][a] = 1;
        }

        DFS(1);
        System.out.println(count);
    }

    static void DFS(int i) {
        check[i] = true;

        for (int j = 1; j <= N; j++) {
            if (map[i][j] == 1 && !check[j]) {
                count++;
                DFS(j);
            }
        }
    }
}
