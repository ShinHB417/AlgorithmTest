
import java.util.*;


public class Main {
    int[] dx = {-1,0,1,0};
    int[] dy = {0,1,0,-1};
    static int white, blue;
    static int[][] board;
    public static boolean checkColor(int row, int col, int n) {

        int color = board[row][col];	// 첫 번째 원소를 기준으로 검사

        for(int i = row; i < row + n; i++) {
            for(int j = col; j < col + n; j++) {
                // 색상이 같이 않다면 false를 리턴
                if(board[i][j] != color) {
                    return false;
                }
            }
        }
        // 검사가 모두 통과했다는 의미이므로 true 리턴
        return true;
    }
    public static void DFS(int row , int col, int n){
        if(checkColor(row,col,n)){
            if(board[row][col] == 0){
                white++;
            }else{
                blue++;
            }
            return;
        }

        int newSize = n/2;
        DFS(row, col, newSize);						        // 2사분면
        DFS(row, col + newSize, newSize);				// 1사분면
        DFS(row + newSize, col, newSize);				// 3사분면
        DFS(row + newSize, col + newSize, newSize);// 4사분면



    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();
        board = new int[n][n];

        for(int i = 0; i<n ; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = scan.nextInt();
            }
        }
        DFS(0,0,n);
        System.out.println(white);
        System.out.println(blue);
    }


}



