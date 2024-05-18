import java.io.*;
import java.util.*;

public class Solution{


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        boolean flag = false;
        String answer="";
        for(int i = 1; i <=n; i++){
            String s = String.valueOf(i);
            int cnt = 0;
            if(s.contains("3")||s.contains("6")||s.contains("9")){
                for(char c : s.toCharArray()){
                    if(Character.getNumericValue(c)==3 || Character.getNumericValue(c)==6|| Character.getNumericValue(c)==9){
                        cnt++;
                    }

                }
                for(int k = 0; k < cnt; k++){
                    answer+="-";
                }
                answer+=" ";
            }else{
                answer+=s+" ";
            }


        }
        System.out.println(answer);


    }

}
