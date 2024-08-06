import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] persons = new int[N][2];

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            persons[i][0] = Integer.parseInt(st.nextToken());
            persons[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];

        for (int i = 0; i < N; i++) {
            answer[i]++;

            for (int j = 0; j < N; j++) {
                if (persons[i][0] < persons[j][0] && persons[i][1] < persons[j][1]) {
                    answer[i]++;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            System.out.println(answer[i]);
        }
    }
}
