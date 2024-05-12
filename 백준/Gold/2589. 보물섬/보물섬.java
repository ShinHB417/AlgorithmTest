import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.text.SimpleDateFormat;
import java.util.*;
class Point{
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main{
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static char[][] board;
    static int[][] dis;
    static int row,col;

    static int answer = Integer.MIN_VALUE;


    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));

        while(!q.isEmpty()){
            Point cur = q.poll();
            for(int i = 0 ; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >=0 && nx < row && ny >=0 && ny < col && dis[nx][ny] == 0 && board[nx][ny] == 'L'){
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                    q.add(new Point(nx,ny));
                    answer = Math.max(answer,dis[nx][ny]);
                }
            }
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];

        for(int i = 0; i <row; i++){
            String s = br.readLine();
            for(int j = 0; j < col; j++){
                board[i][j] = s.charAt(j);
            }
        }

        for(int i = 0; i <row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] =='L'){
                    dis = new int[row][col];
                    dis[i][j] = 1;
                    BFS(i,j);
                }
            }
        }
        System.out.println(answer-1);

    }

}
