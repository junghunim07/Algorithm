import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    static int N;
    static PriorityQueue<Integer> plus = new PriorityQueue<>(Comparator.reverseOrder());
    static PriorityQueue<Integer> minus = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            int num = Integer.parseInt(br.readLine());

            if(num <= 0)
                minus.add(num);
            else
                plus.add(num);
        }
        int answer = 0;

        while(!minus.isEmpty()){
            int cur = minus.poll();
            if(minus.isEmpty()){
                answer += cur;
                break;
            }

            if(minus.peek() == 0)
                minus.poll();
            else
                answer += cur * minus.poll();
        }

        while(!plus.isEmpty()){
            int cur = plus.poll();
            if(plus.isEmpty()){
                answer += cur;
                break;
            }
            if(cur == 1)
                answer += 1;
            else if(plus.peek() == 1)
                answer += cur + plus.poll();
            else
                answer += cur * plus.poll();
        }

        System.out.println(answer);
    }
}
