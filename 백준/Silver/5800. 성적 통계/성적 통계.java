import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 1; i <= T; i++) {
            System.out.printf("Class %d%n", i);

            String[] str = br.readLine().split(" ");

            int[] arr = new int[Integer.parseInt(str[0])];

            for (int j = 0; j < arr.length; j++) {
                arr[j] = Integer.parseInt(str[j + 1]);
            }

            Arrays.sort(arr);
            printMax(arr);
            printMin(arr);
            printMaxGap(arr);
        }
    }

    static void printMax(int[] arr) {
        System.out.print("Max " + arr[arr.length - 1] + ", ");
    }

    static void printMin(int[] arr) {
        System.out.print("Min " + arr[0] + ", ");
    }

    static void printMaxGap(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            max = Math.max(max, arr[i + 1] - arr[i]);
        }

        System.out.println("Largest gap " + max);
    }
}