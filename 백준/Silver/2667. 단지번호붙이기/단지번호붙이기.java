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
    static int totalCnt;
    static ArrayList<Integer> list = new ArrayList<>();

    public static int BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        board[x][y] = 0;
        int cnt = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >=0 && nx < row && ny >=0 && ny < col && board[nx][ny] == 1){
                    board[nx][ny] = 0;
                    cnt++;
                    q.add(new Point(nx,ny));
                }
            }
        }
        return cnt;

    }

    public static void solution(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j] == 1){
                   list.add(BFS(i,j));
                    totalCnt++;
                }
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        row = Integer.parseInt(br.readLine());
        col = row;

        board = new int[row][col];


        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                board[i][j] = str.charAt(j) - '0';
            }
        }

        solution();
        Collections.sort(list);
        System.out.println(totalCnt);
        for(int i : list){
            System.out.println(i);
        }

    }


}