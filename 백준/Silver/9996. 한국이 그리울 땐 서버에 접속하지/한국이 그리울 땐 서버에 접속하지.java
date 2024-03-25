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
        StringBuilder sb = new StringBuilder();
        int n  = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(),"*");
        String pre = st.nextToken();
        String suf = st.nextToken();

        while(n-- > 0){
            String s = br.readLine();
            if(pre.length() + suf.length() > s.length()) sb.append("NE" + "\n");
            else{
                String substring1 = s.substring(0, pre.length());
                String substring2 = s.substring(s.length()-suf.length(),s.length());
                if(pre.equals(substring1) && suf.equals(substring2)) sb.append("DA" + "\n");
                else sb.append("NE" + "\n");
            }

        }
        System.out.println(sb);

    }

}
