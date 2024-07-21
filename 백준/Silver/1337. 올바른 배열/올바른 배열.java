import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] cnt = new int[n];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < 5; j++) {
                if (!list.contains(list.get(i) + j)) {
                    cnt[i]++;
                }
            }
        }

        Arrays.sort(cnt);
        System.out.println(cnt[0]);
    }
}
