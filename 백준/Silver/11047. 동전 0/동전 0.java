import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 종류 수
        int k = Integer.parseInt(st.nextToken()); // 가격
        int idx = 0;
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] =Integer.parseInt(br.readLine());
            if(arr[i] <= k) idx = i;
        }
        int cnt=0;
        while(k>0){

            if(arr[idx] > k){
                idx--;
                continue;
            }
            k -=arr[idx];
            cnt++;
        }
        System.out.println(cnt);


        }



    }
