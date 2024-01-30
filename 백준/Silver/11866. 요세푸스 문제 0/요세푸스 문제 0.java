
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        Queue<String> q = new LinkedList<>();

        int n = scan.nextInt(); // 7명
        int m = scan.nextInt(); // 3번째
        for(int i = 1; i<=n; i++){
            q.add(String.valueOf(i));
        }
        int cnt = 0;
        while(!q.isEmpty()){
            cnt++;
            if(cnt == m){
                sb.append(q.poll() + ", ");
                cnt = 0;
            }else{
                q.add(q.poll());
            }
        }
        sb.delete(sb.length()-2,sb.length());
        sb.append(">");
        System.out.println(sb);
    }


}


