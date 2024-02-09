import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine());

        for(int i = 0; i <tc; i++){
            int cnt = 0;
            HashMap<String, Integer> map = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int j = 0; j < n; j++){
                st = new StringTokenizer(br.readLine());
                st.nextToken();
                String type = st.nextToken();
                map.put(type,map.getOrDefault(type,0)+1);
            }

            int mul = 1;
            if(map.size() == 1){
                cnt = n;
            }else{
                for(String s : map.keySet()){
                   mul *= map.get(s) + 1;
                }
                cnt = mul -1;
            }
            sb.append(cnt + "\n");
        }

        System.out.println(sb);


        }



    }
