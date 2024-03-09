import java.io.*;
import java.util.*;

public class Main {


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int[][] dp = new int[n+1][n+1];

        for(int i = 1; i <=n; i++){
            dp[i][i] = 1;
            if(arr[i] == arr[i-1]){
                dp[i-1][i] = 1;
            }
        }

        for(int i = 2; i < n; i++){
            //i는 간격
            for(int j = 1; j <=n-i; j++){
                if(arr[j] == arr[j+i] && dp[j+1][j+i-1] ==1){
                    dp[j][j+i] = 1;
                }
            }
        }

        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            sb.append(dp[a][b]).append("\n");
        }

        System.out.println(sb);




    }
}