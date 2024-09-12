import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> crane = new ArrayList<>();
        List<Integer> box = new ArrayList<>();

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            crane.add(sc.nextInt());
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            box.add(sc.nextInt());
        }

        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());

        if (crane.get(0) < box.get(0)) {
            System.out.println(-1);
            return;
        }

        int minute = 0;

        while (!box.isEmpty()) {
            int boxIndex = 0;
            int craneIndex = 0;

            while (craneIndex < n) {
                if (boxIndex == box.size())
                    break;
                else if (crane.get(craneIndex) >= box.get(boxIndex)) {
                    box.remove(boxIndex);
                    craneIndex++;
                } else {
                    boxIndex++;
                }
            }

            minute++;
        }

        System.out.println(minute);
    }
}
