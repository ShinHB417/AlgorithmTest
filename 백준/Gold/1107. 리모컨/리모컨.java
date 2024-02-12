import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] arr = {0,1,2,3,4,5,6,7,8,9};
        String n = br.readLine(); //5457


        int m = Integer.parseInt(br.readLine());

        if(m != 0){
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < m; i ++){
                arr[Integer.parseInt(st.nextToken())] = -1;
            }
        }



        // 0 1 2 3 4 5 -1 -1 -1 9
        int result = Math.abs(Integer.parseInt(n) - 100);
        if(result == 0){
            System.out.println(0);
            return;
        }
        for(int i = 0; i <= 999999; i++){
            String str = String.valueOf(i);
            int len = str.length();

            boolean flag = false;
            for(int j = 0; j < len; j++) {
                if (arr[str.charAt(j) - '0'] == -1) {
                    flag = true;
                    break;
                }
            }

                if(!flag){
                    int min = Math.abs(Integer.parseInt(n) - i) + len;
                    result = Math.min(result, min);
                }

        }


        System.out.println(result);




    }
}