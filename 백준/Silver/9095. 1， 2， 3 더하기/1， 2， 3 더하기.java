
import java.util.*;


public class Main {
    static int cnt;
    private static int DFS(int l, int sum, int a) {

        if(sum > a) return 0;
        if(sum == a){
            cnt++;
        }else{
            for(int i = 1; i<=3; i++){
                DFS(l+1, sum+i,a);
            }
        }
        return cnt;
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt(); // 컴퓨터 수 = 노드 수
        for(int i = 0; i < n; i++){
            int a = scan.nextInt();
            sb.append(DFS(0,0,a) + "\n");
            cnt = 0;
        }

        System.out.println(sb);
    }


}



