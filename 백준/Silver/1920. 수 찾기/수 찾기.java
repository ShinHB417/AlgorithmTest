import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        Set<Integer> set = new HashSet<>();
        int n = scan.nextInt();

        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            set.add(a);
        }

        int m = scan.nextInt();
        
        for(int i = 0; i<m; i++){
            int a = scan.nextInt();
            if(set.contains(a)) System.out.println("1");
            else System.out.println("0");
        }

    }
}


