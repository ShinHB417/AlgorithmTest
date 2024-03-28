import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    public static boolean check(char c){
        return (c == 'a'|| c == 'e'|| c == 'i'|| c == 'o'|| c == 'u');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        while(true){
            String s = br.readLine();
            boolean flag = true;
            int cnt1 = 0;
            int cnt2 = 0;
            boolean check = false;
            char pre=' ';
            if(s.equals("end")) break;

           for(char c : s.toCharArray()){

               if(pre == c){
                   if(c == 'e' || c=='o') continue;
                   else{
                       flag = false;
                       break;
                   }
               }
               if(check(c)){
                   cnt1++; // 모음 개수
                   if(cnt1 == 3){
                       flag = false;
                       break;
                   }
                   cnt2 = 0;
                   check = true;
               }else{
                   cnt2++; //자음 개수
                   if(cnt2 == 3){
                       flag = false;
                       break;
                   }
                   cnt1 = 0;
               }
               pre = c;
           }

           if(flag && check) sb.append("<" + s + ">" +  " is acceptable." + "\n");
           else sb.append("<" + s + ">" +  " is not acceptable."+ "\n");




        }

        System.out.println(sb);




    }

}
