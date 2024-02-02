
import java.util.*;


public class Main {


    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            if(a == 0){
                if(pq.isEmpty()){
                    sb.append(0 + "\n");
                }else{
                    sb.append(pq.poll() + "\n");
                }
            }else{
                pq.add(a);
            }
        }

        System.out.println(sb);
    }


}



