import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] answer = new int[n];
        int[] arr = new int[n];
        Arrays.fill(answer,-1);
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i <n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]){
                answer[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        for(int i : answer){
            sb.append(i + " ");
        }
        System.out.println(sb);







    }

}
