import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        String[] list = input.split(" ");

        if(Integer.parseInt(list[0]) > Integer.parseInt(list[1])){
            System.out.println(">");
        } else if (Integer.parseInt(list[0]) < Integer.parseInt(list[1])) {
            System.out.println("<");
        }else{
            System.out.println("==");
        }


    }
}