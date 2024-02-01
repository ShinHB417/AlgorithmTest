
import java.util.*;
class zeroOne{
    int zero, one;
    public zeroOne(int zero, int one){
        this.zero = zero;
        this.one = one;
    }
}

public class Main {
    static zeroOne[] fibo;
    public static void fibonacci(int n){
        fibo[0] = new zeroOne(1,0);
        fibo[1] = new zeroOne(0,1);

        for(int i = 2; i <=n; i++){
            fibo[i] = new zeroOne(fibo[i-1].zero + fibo[i-2].zero, fibo[i-1].one + fibo[i-2].one);
        }
    }
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        fibo = new zeroOne[41];

        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            fibonacci(a);
            sb.append(fibo[a].zero + " " + fibo[a].one + "\n");
        }
        System.out.println(sb);

    }
}



