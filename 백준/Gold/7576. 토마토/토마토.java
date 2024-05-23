import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Main {
    static int[][] board, dis;
    static int row,col;
    static Queue<Point> q = new LinkedList<>();
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int answer = Integer.MIN_VALUE;

    static public void BFS(){

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if(nx>=0 && nx < row && ny >=0 && ny < col && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.add(new Point(nx,ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        col = Integer.parseInt(st.nextToken());
        row = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        dis = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1){
                    q.add(new Point(i,j));
                }
            }
        }
        BFS();

        for(int i = 0; i < row; i ++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 0){
                    System.out.println(-1);
                    return;
                }
                answer = Math.max(answer, dis[i][j]);
            }
        }
        System.out.println(answer);
    }
}
