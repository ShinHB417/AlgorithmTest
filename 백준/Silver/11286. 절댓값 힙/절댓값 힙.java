import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;


public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int a = Math.abs(o1);
                int b = Math.abs(o2);
                if( a > b){
                    //원래 오름차순
                    return a - b;
                }else if( a==b){
                    return o1 - o2;
                }else{
                    return -1;
                }
            }
        });
        while(n -- > 0){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(!pq.isEmpty()) sb.append(pq.poll() + "\n");
                else sb.append(0 + "\n");
            }else{
                pq.add(a);
            }

        }
        System.out.println(sb);

    }
}