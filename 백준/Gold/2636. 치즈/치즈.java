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


public class Main{

    static int row,col;
    static int[][] board, visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Point> list;
    static int cnt;

    public static void DFS(int x, int y){
        visited[x][y] = 1;
        if(board[x][y] ==1){
            list.add(new Point(x,y));
            return;
        }
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < row && ny >= 0 && ny <col && visited[nx][ny] == 0){
               DFS(nx, ny);
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

        int cnt = 0;
        int curSize = 0;

        while(true){
            list = new ArrayList<>();
            visited = new int[row][col];
            DFS(0,0);
            curSize = list.size();
            for(Point p : list){
                board[p.x][p.y] = 0;
            }
            boolean flag = false;
            Loop: for(int i = 0; i < row; i++){
                for(int j = 0; j < col; j++){
                    if(board[i][j] == 1){
                        flag = true;
                        break Loop;
                    }
                }
            }
            cnt++;
            if(!flag) break;
        }
        System.out.println(cnt);
        System.out.println(curSize);

    }

}
