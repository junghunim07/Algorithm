import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> nameKeyPokemon = new HashMap<>();
        HashMap<Integer, String> numKeyPokemon = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String tmp = br.readLine();
            nameKeyPokemon.put(tmp, i);
            numKeyPokemon.put(i, tmp);
        }

        for (int i = 0; i < m; i++) {
            String tmp = br.readLine();

            if (Character.isDigit(tmp.charAt(0))) {
                int num = Integer.parseInt(tmp);
                bw.write(numKeyPokemon.get(num) + "\n");
            } else {
                bw.write(nameKeyPokemon.get(tmp) + "\n");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
