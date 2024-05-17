import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution{

    static int n,r;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        int k = 1;
        while(tc-->0){

            int min = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            arr = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            int answer = Integer.MAX_VALUE;

            for(int i = 0; i <= n-r; i++){
                answer = Math.min(answer, arr[i+r-1] - arr[i]);
            }
            sb.append("#"+k+" " + answer).append("\n");
            k++;
        }
        System.out.println(sb);

    }

}
