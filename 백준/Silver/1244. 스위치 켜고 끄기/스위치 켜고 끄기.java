import java.util.Scanner;

public class Main {
    static int[] lamp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //스위치 수
        lamp = new int[n]; //전구 상태

        for (int i = 0; i < n; i++) {
            lamp[i] = sc.nextInt();
        }

        int student = sc.nextInt(); //학생 수
        int[][] map = new int[student][2];

        for (int i = 0; i < student; i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        for (int i = 0; i < student; i++) {
            if (map[i][0] == 1) {
                reverseSwitchForMan(map[i][1]);
            } else {
                switchLampForWomen(map[i][1]);
            }
        }

        for (int i = 0; i < n; i++) {
            if (i != 0 && i % 20 == 0) {
                System.out.println();
            }
            if (i == n - 1) {
                System.out.print(lamp[i]);
            } else {
                System.out.print(lamp[i] + " ");
            }
        }
    }

    private static void reverseSwitchForMan(int num) {
        for (int i = 0; i < lamp.length; i++) {
            if ((i + 1) % num == 0) {
                if (lamp[i] == 0) {
                    lamp[i] = 1;
                } else {
                    lamp[i] = 0;
                }
            }
        }
    }

    private static void switchLampForWomen(int num) {
        int j = num - 1;

        for (int i = j; i < lamp.length; i++, j--) {
            if (j < 0) {
                break;
            }
            if (lamp[j] == lamp[i]) {
                if (lamp[i] == 0) {
                    lamp[i] = 1;
                    lamp[j] = 1;
                } else {
                    lamp[i] = 0;
                    lamp[j] = 0;
                }
            } else break;
        }
    }
}
