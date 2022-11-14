import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int sum = 0;
        int[] arr = new int[9];

        for(int i = 0; i<9; i ++){
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
            sum += num;
        }

        Loop1 : for(int i = 0; i<8; i++){
            for(int j = i+1; j<9; j++){
                if(sum-100 == arr[i] + arr[j]){
                    arr[i] = 0;
                    arr[j] = 0;
                    break Loop1;
                }
            }
        }

        Arrays.sort(arr);
        for(int i = 2; i<9; i++){
            System.out.println(arr[i]);
        }








    }
}
