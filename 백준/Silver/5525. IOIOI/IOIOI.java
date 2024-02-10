import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int answer = 0;
        String s = "";
        for(int i = 1; i<=2*n+1; i++){
            if(i%2 == 1){
                s+="I";
            }else{
                s+="O";
            }
        }
        int m = Integer.parseInt(br.readLine());
        String str = br.readLine();
        for(int i = 0;  i <= m - s.length(); i++){
            if(str.charAt(i) == 'I'){
                String substring = str.substring(i, i + s.length());
                if(substring.equals(s)) answer++;
            }
        }
        System.out.println(answer);




    }
}