import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int cnt = 0;
        int N = sc.nextInt();
        sc.nextLine();
        ArrayList<String>[] arr = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            arr[i] = new ArrayList<>();
            String tmp = sc.nextLine();

            for (int j = 0; j < tmp.length(); j++) {
                arr[i].add(tmp.substring(j) + tmp.substring(0, j));
            }

            boolean chk = true;
            for (int j = 0; chk && j <= i - 1; j++) {
                for (int k = 0; chk && k < arr[j].size(); k++) {
                    if (tmp.equals(arr[j].get(k)))
                        chk = false;
                }
            }

            if (chk)
                cnt++;
        }
        System.out.println(cnt);
    }
}
