import java.io.*;
import java.util.*;

public class Main {

    public static boolean isPrime(int n){
        if(n == 0 || n ==1) return false;
        for(int i = 2; i <=Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int answer = 0;
        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            if(isPrime(a)){
                answer++;
            }
        }
        System.out.println(answer);

    }
}


