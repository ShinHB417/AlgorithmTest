
import java.util.*;


public class Main {
    static int[] dp;

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <=n; i++){
            dp[i] = (dp[i-1] + dp[i-2]) % 10007;
        }
        System.out.println(dp[n]);

    }


}



