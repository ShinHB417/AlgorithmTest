import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main{



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        //char[][] board = new char[row][col];
        int[][] answer = new int[row][col];
        for(int i = 0; i < row; i++){
            Arrays.fill(answer[i],-1);
        }
        for(int i = 0; i < row; i++){
            String s = br.readLine();
            for(int j = 0; j < col; j++){
                if(s.charAt(j) =='c'){
                    answer[i][j] = 0;
                }
            }
        }
        for(int i = 0; i < row; i++){
            int num = 0;
            boolean flag = false;
            for(int j = 0; j < col; j++){
                if(answer[i][j] == 0){
                    num = 0;
                    flag = true;
                }else{
                    if(flag){
                        num++;
                        answer[i][j] = num;
                    }
                }
            }
        }

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                System.out.print(answer[i][j] + " ");
            }
            System.out.println();
        }




    }

}
