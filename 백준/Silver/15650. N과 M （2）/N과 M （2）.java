import java.sql.SQLOutput;
import java.util.*;



public class Main {
    static int n,r;
    static int[] combi;

    static StringBuilder sb = new StringBuilder();
    public static void DFS(int l, int s){
        if(l == r){
            for(int x : combi){
                sb.append(x + " ");
            }
            sb.append("\n");
        }else{
            for(int i = s; i <= n; i++){
                combi[l] = i;
                DFS(l+1,i+1);
            }
        }


    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        r = scan.nextInt();

        combi = new int[r]; // r개 뽑을것임
        DFS(0,1);
        System.out.println(sb);
    }
}




