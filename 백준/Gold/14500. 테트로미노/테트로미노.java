import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {
    static int row,col;
    static int[][] board;
    static int[][] visited;
    static int answer = Integer.MIN_VALUE;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};


    public static void DFS(int l, int x , int y, int sum){
        if(l == 3){
            answer = Math.max(answer,sum);
        }else{
            visited[x][y] = 1;
            for(int i = 0; i< 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(nx >=0 && nx < row && ny >=0 && ny < col &&visited[nx][ny] == 0){
                    visited[nx][ny] = 1;
                    DFS(l+1,nx,ny,sum + board[nx][ny]);
                    visited[nx][ny] = 0;
                }
            }
        }
    }
    public static void cm(int l , int x , int y, int start, int sum){
        if(l == 3){
            answer = Math.max(answer, sum);
        }else{
            for(int i = start; i < 4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && nx  < row && ny >=0 && ny < col){
                    cm(l+1,x,y,i+1,sum + board[nx][ny]);
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        visited = new int[row][col];


        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
           for(int j = 0; j < col; j++){
               board[i][j] = Integer.parseInt(st.nextToken());
           }
        }
        DFS(0,1,0,board[1][0]);

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                DFS(0,i,j,board[i][j]);
                visited[i][j] = 0;
                cm(0,i,j,0,board[i][j]);
            }
        }


        System.out.println(answer);


    }
}
