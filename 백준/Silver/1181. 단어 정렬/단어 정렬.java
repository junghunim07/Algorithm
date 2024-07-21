import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        List<String> list = new ArrayList<>();

        for (String s : arr) {
            if (!list.contains(s)) {
                list.add(s);
            }
        }

        list.sort(Comparator.naturalOrder());
        list.sort((String a, String b) -> a.length() - b.length());

        for (String s : list) {
            System.out.println(s);
        }
    }
}