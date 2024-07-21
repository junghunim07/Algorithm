import java.util.Scanner;

public class Main {
    static int W, N;
    static int[] answer;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        answer = new int[T];

        for (int i = 0; i < T; i++) {
            int nowPosition = 0;
            int nowWeight = 0;
            W = sc.nextInt();
            N = sc.nextInt();

            for (int j = 0; j < N; j++) {
                int distance = sc.nextInt();
                int weight = sc.nextInt();

                if (nowWeight < W) {
                    answer[i] += (distance - nowPosition);
                    if (nowWeight + weight > W) {
                        answer[i] += (distance * 2);
                        nowPosition = distance;
                        nowWeight = weight;
                    } else if (nowWeight + weight == W) {
                        answer[i] += (distance * 2);
                        nowPosition = distance;
                        nowWeight = 0;
                    } else {
                        nowPosition = distance;
                        nowWeight += weight;
                    }
                }
            }

            if (nowWeight == 0) {
                answer[i] -= nowPosition;
            } else {
                answer[i] += nowPosition;
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
