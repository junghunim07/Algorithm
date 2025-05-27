import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {

    static String[] input;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        System.out.println(process().size());
    }

    static HashSet<String> process() {
        HashSet<String> result = new HashSet<>();

        for (String s : input) {
            if (result.isEmpty()) {
                result.add(s);
                continue;
            }
            
            boolean flag = true;

            for (String setString : result) {
                if (setString.indexOf(s) == 0) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                result.add(s);
            }
        }
        return result;
    }

    static void init(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        input = new String[N];

        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }

        Arrays.sort(input, new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(o2.length(), o1.length());
            }
        });
    }
}
