import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        StringBuilder word = new StringBuilder();
        boolean last = false;

        for (int i = 0; i < str.length(); i++) {

            if (str.charAt(i) == '<') {
                if (word.length() == 0) {
                    last = true;
                } else {
                    word.reverse();
                    bw.write(word.toString());
                    word.delete(0, word.length());
                    last = true;
                }
            }

            if (last) {
                word.append(str.charAt(i));

                if (str.charAt(i) == '>') {
                    last = false;
                    bw.write(word.toString());
                    word.delete(0, word.length());
                }
            } else {
                if (str.charAt(i) == ' ') {
                    word.reverse();
                    bw.write(word + " ");
                    word.delete(0, word.length());
                } else {
                    word.append(str.charAt(i));
                }
            }

            if (i == str.length() - 1) {
                word.reverse();
                bw.write(word.toString());
                word.delete(0, word.length());
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
