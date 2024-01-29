import java.io.*;
import java.util.*;

public class Main {

    public static int solution(int n, int m, String[] arr){
        int cnt = 0;
        String[] answer = {"WBWBWBWB", "BWBWBWBW"};
        for(int i = 0; i <8; i++){
            int row = n + i;
            for(int j = 0; j < 8; j++){
                int col = m + j;

                if(arr[row].charAt(col) != answer[row%2].charAt(j)){
                    cnt++;
                }
            }
        }
        return Math.min(cnt,64-cnt);
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); // 10
        int m = scan.nextInt(); // 13
        scan.nextLine();
        String[] arr = new String[n];
        for(int i = 0; i < n; i++){
            arr[i] = scan.nextLine();
        }
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i <= n-8; i++){
            for(int j = 0; j<= m-8; j++){
                //시작점 찾기
                answer = Math.min(answer,solution(i,j,arr));
            }
        }
        System.out.println(answer);
    }
}
