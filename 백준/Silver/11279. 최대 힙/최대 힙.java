import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {




    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            int a = Integer.parseInt(br.readLine());
            if(a == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll() + "\n");
                }else{
                    sb.append(0 + "\n");
                }
            }else{
                pq.add(a);
            }
        }
        System.out.println(sb);
        br.close();

    }


}