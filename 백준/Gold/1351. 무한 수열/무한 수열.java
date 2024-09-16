import java.io.*;
import java.util.*;

public class Main {

    static Map<Long, Long> map;
    static long n;
    static long p;
    static long q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Long.parseLong(st.nextToken());
        p = Long.parseLong(st.nextToken());
        q = Long.parseLong(st.nextToken());
        map = new HashMap<>();
        map.put(0L, 1L);

        System.out.println(solve(n));
    }

    static long solve(long n) {
        if (map.containsKey(n))
            return map.get(n);

        long i = solve((long)Math.floor(n/p));
        long j = solve((long)Math.floor(n/q));

        map.put(n, i + j);
        return i + j;
    }
}
