import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int[] count = new int[2];
        char near = str.charAt(0);
        count[Character.getNumericValue(near)]++;

        for (int i = 0; i < str.length(); i++) {
            if (near != str.charAt(i)) {
                count[Character.getNumericValue(str.charAt(i))]++;
                near = str.charAt(i);
            }
        }

        if(count[0] <= count[1]) {
            System.out.println(count[0]);
        } else {
            System.out.println(count[1]);
        }
    }
}