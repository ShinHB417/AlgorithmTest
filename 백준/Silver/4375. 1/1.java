import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s;
        while((s=br.readLine()) != null){
            int i = 1;
            int cnt = 1;
            int num = Integer.parseInt(s);
            while((i = i % num) != 0){
                cnt++;
                i = i*10 +1;

            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);





    }

}
