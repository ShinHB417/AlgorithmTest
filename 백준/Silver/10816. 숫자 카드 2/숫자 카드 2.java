
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i <n; i++){
            int a = scan.nextInt();
            map.put(a,map.getOrDefault(a,0) + 1);
        }
        int m = scan.nextInt();
        for(int i = 0; i <m; i++){
            int a = scan.nextInt();
            if(map.containsKey(a)){
                sb.append(map.get(a) + " ");
            }else{
                sb.append("0 ");
            }
        }
        System.out.println(sb);
    }


}


