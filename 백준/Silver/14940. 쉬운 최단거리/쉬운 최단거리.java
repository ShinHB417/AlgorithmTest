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

    static Point start;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int[][] dis;
    static int row,col;
    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >=0 && nx < row && ny >=0 && ny < col && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    q.add(new Point(nx,ny));
                }
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        dis = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 2){
                    start = new Point(i,j);
                }
            }
        }
        dis[start.x][start.y] = 0;
        BFS(start.x, start.y);

        for(int i = 0; i < dis.length; i++){
            for(int j = 0; j < dis[0].length; j++){
                if(board[i][j] == 1){
                    dis[i][j] = -1;
                }
                sb.append(dis[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
