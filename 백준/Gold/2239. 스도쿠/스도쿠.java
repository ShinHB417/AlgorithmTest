import java.io.*;
import java.util.*;

public class Main {

    static int[][] board;
    static ArrayList<int[]> list = new ArrayList<>();

    public static void DFS(int l){
        if(l == list.size()){
            for(int i = 0; i < 9; i++){
                for(int j = 0; j < 9; j++){
                    System.out.print(board[i][j]);
                }
                    System.out.println();
            }
            System.exit(0);
        }else{
            int x =list.get(l)[0];
            int y =list.get(l)[1];

            boolean[] check = new boolean[10];
            //한 점의 0을 채우려면 3가지 조건을 확인해야함
            // 행, 열 , 박스

            for(int i = 0; i < 9; i++){
                if(board[x][i] != 0){
                    check[board[x][i]] = true;
                }
            }

            for(int i = 0; i < 9; i++){
                if(board[i][y] != 0){
                    check[board[i][y]] = true;
                }
            }

            int startX = x/3 * 3;
            int startY = y/3 * 3;
            for(int i = startX; i < startX+3; i++){
                for(int j = startY; j < startY+3; j++){
                    if(board[i][j] != 0){
                        check[board[i][j]] = true;
                    }
                }
            }

            for(int i = 1; i < 10; i++){
                if(check[i] == false){
                    board[x][y] = i;
                    DFS(l+1);
                    board[x][y] = 0;
                }
            }
        }
    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        board = new int[9][9];

        for(int i = 0; i < 9; i++){
            String str = br.readLine();
            for(int j = 0; j < 9; j++){
                board[i][j] = str.charAt(j) - '0';

                if(board[i][j] == 0) list.add(new int[] {i,j});
            }
        }
        DFS(0);
    }
}