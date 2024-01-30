import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args){
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        
        int n = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            list.add(a);
        }
        Collections.sort(list);
        for(int i : list){
            sb.append(i).append("\n");
        }
        System.out.println(sb);


    }


}


