import java.util.*;



public class Main {
    final static int red = 0;
    final static int green = 1;
    final static int blue = 2;




    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] dp = new int[n][3];

        for(int i = 0; i < n; i++){
            int r = scan.nextInt();
            int g = scan.nextInt();
            int b = scan.nextInt();

            dp[i][red] = r;
            dp[i][green] = g;
            dp[i][blue] = b;
        }

        for(int i = 1; i < n; i++){
            dp[i][red] += Math.min(dp[i-1][green], dp[i-1][blue]);
            dp[i][green] += Math.min(dp[i-1][red], dp[i-1][blue]);
            dp[i][blue] += Math.min(dp[i-1][green], dp[i-1][red]);
        }

        System.out.println(Math.min(dp[n-1][red],Math.min(dp[n-1][green],dp[n-1][blue])));



    }
}




