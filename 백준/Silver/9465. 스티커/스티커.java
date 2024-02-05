import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int[][] arr, dp;
    static int n,m;

    public static void dp(){
        for(int i = 2; i<=m; i++){
            dp[0][i] = arr[0][i] + Math.max(dp[1][i-1], dp[1][i-2]);
            dp[1][i] = arr[1][i] + Math.max(dp[0][i-1], dp[0][i-2]);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < n; i++){
            m = Integer.parseInt(br.readLine());
            arr = new int[2][m+1];
            dp = new int[2][m+1];

            for(int j = 0; j < 2; j++){
                String[] str = br.readLine().split(" ");
                for(int k = 1; k <= m; k++){
                    arr[j][k] = Integer.parseInt(str[k-1]);
                }
            }
            dp[0][1] = arr[0][1];
            dp[1][1] = arr[1][1];
            dp();
            sb.append(Math.max(dp[0][m], dp[1][m]) + "\n");
        }
        System.out.println(sb);
    }


}




