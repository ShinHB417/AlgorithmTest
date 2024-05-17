import java.io.*;
import java.util.*;

public class Solution{

    static int n,r;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int k = 1;
        while(tc -->0){
            String s = br.readLine();
            int len = s.length();
            sb = new StringBuilder(s);
            if(!sb.reverse().toString().equals(s)){
                System.out.println("#"+k+" NO");
                k++;
                continue;
            }
            String subFront = s.substring(0, len / 2);
            sb = new StringBuilder(subFront);
            if(!sb.reverse().toString().equals(subFront)){
                System.out.println("#"+k+" NO");
                k++;
                continue;
            }
            String subRear = s.substring(len / 2 + 1, s.length());
            sb = new StringBuilder(subRear);
            if(!sb.reverse().toString().equals(subRear)){
                System.out.println("#"+k+" NO");
                k++;
                continue;
            }
            System.out.println("#"+k+" YES");
            k++;

        }
        bw.flush();


    }

}
