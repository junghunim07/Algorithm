import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] persons = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            persons[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[N];
        for (int i = 0; i < N; i++) {
            int j = 0;

            while(true) {
                if (persons[i] == 0 && answer[j] == 0) {
                    answer[j] = i + 1;
                    break;
                }
                else if(answer[j] == 0)
                    persons[i]--;

                j++;
            }
        }

        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}