import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;



public class Main {

    static int[][] arr, dp;
    static int n,m;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n * n
        m = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        arr = new int[n+1][n+1];
        dp = new int[n+1][n+1];

        for(int i = 1; i< n+1; i++){
            String[] s = br.readLine().split(" ");
            for(int j = 1; j <n+1; j++){
                arr[i][j] = Integer.parseInt(s[j-1]);
            }
        }

        dp[1][1] = arr[1][1];
        for(int i = 1; i < n+1; i++){
            for(int j = 1; j < n+1; j++){
                if(i == 1 && j ==1) continue;
                dp[i][j] = arr[i][j] + dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1];
            }
        }

        for(int i = 0; i< m; i++){
            String[] s = br.readLine().split(" ");
            int x1 = Integer.parseInt(s[0]);
            int y1 = Integer.parseInt(s[1]);
            int x2 = Integer.parseInt(s[2]);
            int y2 = Integer.parseInt(s[3]);
            sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1] + "\n");
        }
        System.out.println(sb);
    }



}




