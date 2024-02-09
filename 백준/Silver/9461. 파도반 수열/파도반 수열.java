import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());
        while(tc -- > 0){
            int n = Integer.parseInt(br.readLine());
            if(n == 1 || n==2 || n==3){
                sb.append(1 + "\n");
                continue;
            }
            if(n == 4 || n== 5){
                sb.append(2 + "\n");
                continue;
            }
            long[] dp = new long[n+1];
            dp[1] = dp[2] = dp[3] =  1;
            dp[4] = dp[5] = 2;
            for(int i = 6; i<=n; i++){
                dp[i] = dp[i-1] + dp[i-5];
            }
            sb.append(dp[n] + "\n");
        }


        System.out.println(sb);


        }



    }
