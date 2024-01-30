import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for(int i = 1; i <=n; i++){
            q.add(i);
        }
        boolean flag = true;
        while(q.size() != 1){
            if(!q.isEmpty()){
                if(flag){
                    q.poll();
                }else{
                    q.add(q.poll());

                }
            }
            flag = !flag;
        }
        if(!q.isEmpty()) System.out.println(q.poll());


    }
}


