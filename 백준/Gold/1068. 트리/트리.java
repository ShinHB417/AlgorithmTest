import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    static ArrayList<ArrayList<Integer>> tree;
    static int n, root,rm;
    public static int DFS(int here){
        int ret = 0;
        int child = 0;
        for(int there : tree.get(here)){
            //삭제할 노드라면 탐색하지 않고 continue;
            if(there == rm) continue;
            child++;
            ret +=DFS(there);
        }
        if(child == 0) return 1;
        return ret;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        tree = new ArrayList<>();
        for(int i = 0; i < n; i++){
            tree.add(new ArrayList<>());
        }
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int num = Integer.parseInt(st.nextToken());
            if(num == -1){
              root = i;
              continue;
            }
            tree.get(num).add(i);
        }

        rm = Integer.parseInt(br.readLine());
        if(rm == root){
            System.out.println(0);
            return;
        } else{
            System.out.println(DFS(root));
        }





    }

}
