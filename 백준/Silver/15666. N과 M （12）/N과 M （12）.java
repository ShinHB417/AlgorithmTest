import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int n,m;
    static int[] pm, arr;
    static StringBuilder sb = new StringBuilder();
    static Set<String> set = new LinkedHashSet<>();

    public static void DFS(int l, int s){
        if(l == m){
            String str = "";
            for(int x : pm){
                str+=x + " ";
            }
            set.add(str);
        }else{
            for(int i = s; i <n; i++){
                pm[l] = arr[i];
                DFS(l+1,i);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 3
        m = Integer.parseInt(st.nextToken()); // 1
        pm = new int[m];
        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i= 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        DFS(0,0);
        for(String s : set){
            sb.append(s + "\n");
        }
        System.out.println(sb);
        br.close();





    }
}
