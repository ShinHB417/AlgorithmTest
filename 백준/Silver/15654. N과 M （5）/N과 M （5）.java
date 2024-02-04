import java.sql.SQLOutput;
import java.util.*;



public class Main {
    static int n,r;
    static int[] arr, checked,pm;

    static StringBuilder sb = new StringBuilder();
    public static void DFS(int l){
        if(l == r){
            for(int p : pm){
                sb.append(p + " ");
            }
            sb.append("\n");
        }else{
            for(int i = 0; i < n; i++){
                if(checked[i] == 0){
                    pm[l] = arr[i];
                    checked[i] = 1;
                    DFS(l+1);
                    checked[i] = 0;
                }

            }
        }
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);

        n = scan.nextInt();
        r = scan.nextInt();
        arr = new int[n];
        checked = new int[n];
        pm = new int[r];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        DFS(0);

        System.out.println(sb);
    }
}




