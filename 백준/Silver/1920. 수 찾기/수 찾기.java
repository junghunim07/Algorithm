import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        init(br);
        System.out.println(result(target(br)));;
    }

    static StringBuilder result(int[] target){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < target.length; i++) {
            sb.append(set.contains(target[i]) ? "1\n" : "0\n");
        }
        return sb;
    }

    static int[] target(BufferedReader br) throws IOException {
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[M];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }

    static void init(BufferedReader br) throws IOException {
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        set = new HashSet<>();

        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
    }
}
