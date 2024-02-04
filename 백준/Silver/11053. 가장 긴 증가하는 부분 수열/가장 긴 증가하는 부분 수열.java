import java.util.*;



public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] arr = new int[n];
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            int a = scan.nextInt();
            arr[i] = a;
        }
        dp[0] = 1;

        for(int i = 1; i < n; i++){
            int max = 0;
            for(int j = i-1; j >=0; j--){
                if(arr[i] > arr[j]){
                    max = Math.max(max, dp[j]);
                }
                dp[i] = max + 1;
            }

        }
        int result = Arrays.stream(dp).max().getAsInt();
        System.out.println(result);
    }
}




