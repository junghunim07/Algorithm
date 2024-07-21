import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> board = new ArrayList<>();

        for (int i = 0; i < 36; i++) {
            board.add(sc.nextLine());
        }

        if (checkingValidation(board)) {
            System.out.println("Valid");
        } else {
            System.out.println("Invalid");
        }
    }

    private static boolean checkingValidation(List<String> board) {
        Set<String> set = new HashSet<>(board);

        if (set.size() != 36) {
            return false;
        }

        String tmp = board.get(0);

        if (!checkingDistance(tmp, board.get(35))) {
            return false;
        }

        for (int i = 1; i < board.size(); i++) {
            if(!checkingDistance(tmp, board.get(i))) {
                return false;
            }

            tmp = board.get(i);
        }

        return true;
    }

    private static boolean checkingDistance(String a, String b) {
        int a1 = Math.abs(a.charAt(0) - b.charAt(0));
        int a2 = Math.abs(a.charAt(1) - b.charAt(1));

        if ((a1 + a2) != 3) {
            return false;
        }
        if (a1 == 3 || a2 == 3) {
            return false;
        }

        return true;
    }
}
