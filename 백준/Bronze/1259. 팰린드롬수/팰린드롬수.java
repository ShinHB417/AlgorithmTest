import java.io.*;
import java.util.*;

public class Main {



    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        while(true){
            String s = scan.nextLine();
            if(s.equals("0")) break;

            StringBuilder sb = new StringBuilder(s);
            if(s.equals(sb.reverse().toString())){
                System.out.println("yes");
            }else{
                System.out.println("no");
            }
        }
    }
}
