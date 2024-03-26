import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[] cnt = new int[200];
        char mid = ' ';
        int flag = 0;
        String answer="";
        String s = br.readLine();
        for(char c : s.toCharArray()) cnt[c]++;
        for(int i = 'Z'; i >='A'; i--){
            if(cnt[i] != 0){
                if((cnt[i] %2) != 0){
                    //홀수면 가운데 넣어줘야함
                    mid = (char) i;
                    flag++;
                    cnt[i]--;
                }
                if(flag ==2){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                for(int j = 0; j < cnt[i]; j+=2){
                    answer = (char)i + answer;
                }
            }
        }
        String reverse = new StringBuilder(answer).reverse().toString();
        if(mid !=' ') System.out.println(answer + mid + reverse);
        else System.out.println(answer + reverse);




    }

}
