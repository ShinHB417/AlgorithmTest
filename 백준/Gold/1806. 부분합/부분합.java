import java.io.*;
import java.util.*;

public class Main {

    static int n,s;
    static int[] arr;
    static int answer = Integer.MAX_VALUE;

    static public void solution(){
        int lt = 0;
        int sum = 0;
        //1 2 3 4 5 5 7 8 9 10
        for(int rt = 0; rt <n; rt ++){
            sum += arr[rt];

            if(sum >=s){
                while(sum >= s){
                    answer = Math.min(answer,rt-lt+1);
                    sum -=arr[lt];
                    lt++;
                }
            }

        }
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        solution();
        if(answer == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(answer);










    }
}