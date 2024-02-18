import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int n,m;
    static int[] pm;
    static StringBuilder sb = new StringBuilder();

    public static void DFS(int l, int s){
        if(l == m){
            for(int x : pm){
                sb.append(x + " ");
            }
            sb.append("\n");
        }else{
            for(int i = s; i <=n; i++){
                pm[l] = i;
                DFS(l+1,i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        pm = new int[m];
        DFS(0,1);
        System.out.println(sb);
        br.close();





    }
}
