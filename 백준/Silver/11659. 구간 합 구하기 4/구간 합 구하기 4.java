
import java.util.*;


public class Main {
    static int[] dp, arr;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        int m = scan.nextInt();
        dp = new int[n+1];
        arr = new int[n+1];

        for(int i = 1; i<=n; i++){
            arr[i] = scan.nextInt();
        }
        dp[1] = arr[1];
        for(int i = 2; i <=n; i++){
            dp[i] = dp[i-1] + arr[i];
        }
        for(int i = 0; i<m; i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            int answer = dp[e] - dp[s-1];
            sb.append(answer + "\n");
        }
        System.out.println(sb);
    }


}



