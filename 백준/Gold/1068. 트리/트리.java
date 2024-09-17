import java.io.*;
import java.util.*;

public class Main {

    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int deleteNode, root, answer, N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        tree = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            int node = sc.nextInt();

            if (node == -1) {
                root = i;
            } else {
                tree[i].add(node);
                tree[node].add(i);
            }
        }
        
        deleteNode = sc.nextInt();
        
        if (deleteNode == root) {
            System.out.println(0);
            return;
        } else {
            DFS(root);
        }
        System.out.println(answer);
    }
    
    static void DFS(int node) {
        visited[node] = true;
        int child = 0;

        for (Integer i : tree[node]) {
            if (!visited[i] && i != deleteNode) {
                child++;
                DFS(i);
            }
        }

        if (child == 0) {
            answer++;
        }
    }
}
