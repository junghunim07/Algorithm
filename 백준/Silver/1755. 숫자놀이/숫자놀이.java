import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static class Word implements Comparable<Word> {
        int num;
        String str;

        Word(String str, int num) {
            this.str = str;
            this.num = num;
        }

        @Override
        public int compareTo(Word o) {
            return this.str.compareTo(o.str);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();
        String[] word = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        ArrayList<Word> arr = new ArrayList<>();

        for (int i = m; i <= n; i++) {
            String tmp = Integer.toString(i);
            char[] nums = tmp.toCharArray();
            tmp = "";
            for (int j = 0; j < nums.length; j++) {
                tmp += word[nums[j] - '0'];
            }
            arr.add(new Word(tmp, i));
        }

        Collections.sort(arr);

        for (int i = 0; i < arr.size(); i++) {
            System.out.print(arr.get(i).num + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}