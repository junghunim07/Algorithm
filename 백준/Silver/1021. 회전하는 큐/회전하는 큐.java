import java.util.*;

public class Main {
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        LinkedList<Integer> deque = new LinkedList<>();

        int cnt = 0;

        int n = sc.nextInt();
        int m = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            deque.offer(i);
        }

        int[] seq = new int[m];

        for (int i = 0; i < m; i++) {
            seq[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            int target_idx = deque.indexOf(seq[i]);
            int half_idx;

            if (deque.size() % 2 == 0) {
                half_idx = deque.size() / 2 - 1;
            } else {
                half_idx = deque.size() / 2;
            }

            if(target_idx <= half_idx) {
                for(int j = 0; j < target_idx; j++) {
                    int temp = deque.pollFirst();
                    deque.offerLast(temp);
                    cnt++;
                }
            }
            else {
                for(int j = 0; j < deque.size() - target_idx; j++) {
                    int temp = deque.pollLast();
                    deque.offerFirst(temp);
                    cnt++;
                }

            }
            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}