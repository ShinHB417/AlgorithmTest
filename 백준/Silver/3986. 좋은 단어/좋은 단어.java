import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int answer = 0;

        while(n-->0){
            Stack<Character> stack = new Stack<>();
            String s = br.readLine();
            for(int i = 0; i < s.length(); i++){
                char c = s.charAt(i);
                if(!stack.isEmpty()){
                    if(stack.peek() == c){
                        stack.pop();
                    }else{
                        stack.push(c);
                    }
                }else{
                    stack.push(c);
                }
            }
            if(stack.isEmpty()) answer++;
        }
        System.out.println(answer);




    }

}
