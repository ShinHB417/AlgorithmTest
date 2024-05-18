import java.io.*;
import java.util.*;

public class Solution{

    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int n;
    static int[][] board;

    public static void DFS(int x , int y, int num){
        board[x][y] = num;
        for(int i = 0; i < 4; i++){
            if(y ==0 && x != 0 && i!=3 && x-1 !=0) continue;

            int nx = x + dx[i];
            int ny = y + dy[i];


            if(nx >=0 && nx < n && ny >=0 && ny <n && board[nx][ny] == 0){
                DFS(nx,ny,num+1);
            }

        }


    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb;
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int tc = Integer.parseInt(br.readLine());
        int k = 1;
        while(tc -->0){
            n = Integer.parseInt(br.readLine());
            board = new int[n][n];
            DFS(0,0,1);
            System.out.println("#"+k);
            k++;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }

        }


    }

}
