import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        Stack<Character> stack = new Stack<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int num = Integer.parseInt(br.readLine());

        for(int i = 0; i< num; i++){

            String str = br.readLine();
            String[] arr = str.split(" ");

            for(int j = arr.length - 1 ; j>=0; j--){
                
                stack.push(' ');
                
                for(int k = 0; k<arr[j].length(); k++){

                stack.push(arr[j].charAt(k));


                }


            }

            while(!stack.isEmpty()){
                bw.write(stack.pop());

            }
        bw.write("\n");
        }

        bw.flush();

    }
}