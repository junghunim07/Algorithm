import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();
        HashMap<String, Integer> book = new HashMap<>();
        int basic = 0;

        for (int i = 0; i < n; i++) {
            String name = sc.nextLine();
            if (book.containsKey(name)) {
                book.put(name, book.get(name) + 1);
            } else {
                book.put(name, basic);
            }
        }

        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        Map.Entry<String, Integer> maxEntry = null;

        for (Map.Entry<String, Integer> entry : book.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
                sortedMap.clear();
                sortedMap.put(entry.getKey(), entry.getValue());
            } else if (entry.getValue().equals(maxEntry.getValue())) {
                sortedMap.put(entry.getKey(), entry.getValue());
            }
        }

        System.out.println(sortedMap.firstKey());
    }
}
