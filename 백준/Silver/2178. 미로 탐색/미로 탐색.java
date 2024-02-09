import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static class Point{
        int x,y;
        public Point(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    static int[][] board, dis;
    static int row,col;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        board[x][y] = 0;
        dis[x][y] = 1;

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
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new int[row][col];
        dis = new int[row][col];

        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        BFS(0,0);
        System.out.println(dis[row-1][col-1]);
        br.close();


    }


}