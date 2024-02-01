
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        // 1
        // 1 2
        // 1 2 3
        // 1 2 3 3
        // 1 2 3 3 4
        int n = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i< n; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int sum = 0;
        for(int i = 0; i<n; i++){
            sum += arr[i] * (n-i);
        }
        System.out.println(sum);
    }


}


