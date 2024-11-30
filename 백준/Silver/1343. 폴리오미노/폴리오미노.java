import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        System.out.println(poliomino(s));
    }

    static String poliomino(String s) {
        String answer = "";
        String A = "AAAA";
        String B = "BB";

        s = s.replaceAll("XXXX", A);
        answer = s.replaceAll("XX", B);

        if (answer.contains("X")) {
            answer = "-1";
        }

        return answer;
    }
}