import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Mission {
    int day;
    int pride;

    Mission(int day, int pride) {
        this.day = day;
        this.pride = pride;
    }
}

public class Main {

    static List<Mission> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        list = new ArrayList<>();

        int maximumDay = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pride = Integer.parseInt(st.nextToken());
            list.add(new Mission(day, pride));
            maximumDay = Math.max(maximumDay, day);
        }

        int total = 0;

        for (int i = maximumDay; i > 0; i--) {
            total += solve(i);
        }

        System.out.println(total);
    }

    static int solve(int now) {
        int index = -1;
        int result = 0;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).day >= now && result < list.get(i).pride) {
                index = i;
                result = list.get(i).pride;
            }
        }

        if (result == 0) {
            return 0;
        }

        list.remove(index);
        return result;
    }
}
