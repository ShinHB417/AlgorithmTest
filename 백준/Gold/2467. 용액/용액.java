import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int[] arr;

    static StringBuilder sb = new StringBuilder();

    static int n, lt = 0, rt;

    public static void solution(){
        int min = Integer.MAX_VALUE;
        int ml = 0,mr = 0;
        while(lt < rt){
            int sum = arr[lt] + arr[rt];
            if(min > Math.abs(sum)){
                min = Math.abs(sum);
                ml = lt; mr = rt;
            }
            if(sum >=0){
                rt--;
            }else{
                lt++;
            }

        }

        sb.append(arr[ml]).append(" ").append(arr[mr]);

    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        rt = n-1;

        solution();
        System.out.println(sb);







    }
}