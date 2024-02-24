import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int first = 666;
        int cnt = 1;
        while(cnt != n) {
            first++;
            String s = String.valueOf(first);

            if(s.contains("666")){
                cnt++;
            }


        }
        System.out.println(first);
    }

}