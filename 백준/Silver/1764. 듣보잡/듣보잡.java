import java.util.*;

public class Main {
    static List<String> answer;
    static Map<String, Integer> notListening;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        notListening = new HashMap<>();
        answer = new ArrayList<>();

        sc.nextLine();

        for (int i = 0; i < n; i++) {
            notListening.put(sc.nextLine(), 1);
        }

        for (int i = 0; i < m; i++) {
            String tmp = sc.nextLine();
            notListening.put(tmp, notListening.getOrDefault(tmp, 0) + 1);
            if (notListening.get(tmp) == 2)
                answer.add(tmp);
        }

        Collections.sort(answer);

        System.out.println(answer.size());
        for (String s : answer) {
            System.out.println(s);
        }
    }
}
