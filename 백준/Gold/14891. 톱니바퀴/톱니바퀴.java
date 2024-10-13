import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] wheels = new int[5][8];

        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();

            for(int j = 0; j < 8; j++) {
                wheels[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }

        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int[] directions = getDirections(wheels, num, dir);

            for (int j = 1; j <= 4; j++) {
                if(directions[j] != 0) {
                    rotate(wheels[j], directions[j]);
                }
            }
        }

        int answer = getScore(wheels);

        System.out.println(answer);
    }

    private static int getScore(int[][] wheels) {
        int answer = 0;
        int score = 1;

        for (int i = 1; i <= 4; i++) {
            if (wheels[i][0] == 1) {
                answer += score;
            }

            score *= 2;
        }
        return answer;
    }

    private static int[] getDirections(int[][] wheels, int num, int dir) {
        int[] directions = new int[5];
        directions[num] = dir;

        //회전 시킬 바퀴를 기준으로 왼쪽 바퀴들의 회전 여부와 방향을 구한다.
        for (int j = num; j > 1; j--) {
            if (wheels[j][6] ==  wheels[j-1][2]) {
                break;
            }

            directions[j-1] = directions[j] * -1;
        }

        for (int j = num; j < 4; j++) {
            if (wheels[j][2] == wheels[j+1][6]) {
                break;
            }

            directions[j+1] = directions[j] * -1;
        }
        return directions;
    }

    private static void rotate(int[] wheel, int dir) {
        if (dir == 1) {
            int temp = wheel[7];

            for (int i = 7; i > 0; i--) {
                wheel[i] = wheel[i-1];
            }

            wheel[0] = temp;
        } else if (dir == -1) {
            int temp = wheel[0];

            for (int i = 0; i < 7; i++) {
                wheel[i] = wheel[i+1];
            }

            wheel[7] = temp;
        }
    }
}