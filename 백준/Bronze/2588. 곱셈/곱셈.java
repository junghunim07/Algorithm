import java.util.Scanner;

class Main {
    public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        
        int a = in.nextInt();
        int b = in.nextInt();
        int f = b % 100;
        
        int c = b / 100;
        int d = f / 10;
        int e = f % 10;
        
        System.out.println(a * e);
        System.out.println(a * d);
        System.out.println(a * c);
        System.out.println(a * b);
    }
}