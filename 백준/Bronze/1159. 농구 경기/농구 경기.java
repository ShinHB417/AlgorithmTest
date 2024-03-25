import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        while(n -- > 0){
            String s = br.readLine();
            map.put(s.charAt(0), map.getOrDefault(s.charAt(0),0)+1);
        }

        for(char c : map.keySet()){
            if(map.get(c) >=5) sb.append(c);
        }
        if(sb.length() == 0) System.out.println("PREDAJA");
        else System.out.println(sb);

    }

}
