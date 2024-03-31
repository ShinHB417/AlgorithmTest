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
    static int[][] board,virus;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static Point[] combi = new Point[3];
    static ArrayList<Point> list = new ArrayList<>();

    static int answer = Integer.MIN_VALUE;

    public static void wall(int l, int idx){
        if(l == 3){
            //3개 뽑았으면 그 board에서 탐색
            BFS();
            return;
        }
        //벽 3개 뽑는 함수
        for(int i = idx; i < list.size(); i++){
            board[list.get(i).x][list.get(i).y] = 1;
            wall(l+1,i+1);
            board[list.get(i).x][list.get(i).y] = 0;
        }
    }

    public static void BFS(){
        Queue<Point> q = new LinkedList<>();
        virus = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                virus[i][j] = board[i][j];
                if (virus[i][j] == 2) {
                    //큐에 한번에 넣고 bfs로 퍼뜨린다
                    q.add(new Point(i, j));
                }
            }
        }

        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < row && ny >=0 && ny <col && virus[nx][ny] == 0){
                    virus[nx][ny] = 2;
                    q.add(new Point(nx,ny));
                }

            }
        }
        int cnt = 0;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(virus[i][j] == 0) cnt++;
            }
        }
        answer = Math.max(answer,cnt);
    }





    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new int[row][col];

        for(int i = 0; i < row; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < col; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 0) list.add(new Point(i,j));
            }
        }
        wall(0,0);

        System.out.println(answer);









    }

}
