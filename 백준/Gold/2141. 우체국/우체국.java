import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Town implements Comparable<Town> {
    int pos;
    int people;

    public Town(int pos, int people) {
        this.pos = pos;
        this.people = people;
    }


    @Override
    public int compareTo(Town o) {
        return this.pos - o.pos;
    }
}

public class Main {

    static ArrayList<Town> towns;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long totalPeople = 0;
        towns = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int pos = Integer.parseInt(st.nextToken());
            int people = Integer.parseInt(st.nextToken());
            towns.add(new Town(pos, people));
            totalPeople += people;
        }

        Collections.sort(towns);
        solve(totalPeople);
    }

    static void solve(long total) {
        long medium = 0;

        for (int i = 0; i < towns.size(); i++) {
            medium += towns.get(i).people;

            if ((total + 1) / 2 <= medium) {
                System.out.println(towns.get(i).pos);
                break;
            }
        }
    }
}
