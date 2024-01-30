import java.io.*;
import java.util.*;

public class Main {
    static int[][] memo = new int[15][15];
    public static int DFS(int n, int m){
        if(memo[n][m] > 0) return memo[n][m];
        if( n== m || m == 0) return 1;
        else return memo[n][m] = DFS(n-1,m-1) + DFS(n-1,m);
    }

    public static void main(String[] args){
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();

        System.out.println(DFS(n,m));
    }


}


