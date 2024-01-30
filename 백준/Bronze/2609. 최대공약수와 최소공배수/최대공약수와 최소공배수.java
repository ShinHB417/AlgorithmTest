import java.io.*;
import java.util.*;

public class Main {
    public static int GCD(int a, int b) {
        // a > b
        while(b > 0) {
            int tmp = a;
            a = b;
            b = tmp % b;
        }
        return a;
    }
    private static int LCM(int n, int m, int gcd) {
        return n * m /gcd;
    }


    public static void main(String[] args){
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int gcd = GCD(Math.max(n,m), Math.min(n,m));
        int lcm = LCM(n,m,gcd);
        System.out.println(gcd + "\n" + lcm);


    }


}


