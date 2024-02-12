import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
    int x, y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Main {

    static int[][] board;
    static int row,col,answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static ArrayList<Integer> list = new ArrayList<>();

    public static int BFS(int x, int y){
        int cnt = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        board[x][y] = 1;
        while(!q.isEmpty()){
            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >= 0 && nx < row && ny >= 0 && ny < col && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    q.add(new Point(nx, ny));
                    cnt++;
                }
            }
        }
        return cnt;

    }
    public static void solution(){
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(board[i][j]==0){
                    list.add(BFS(i,j));
                    answer++;
                }

            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st =new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        board = new int[row][col];

        for(int i = 0; i < k; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int y=y1; y<y2; y++) {
                for(int x=x1; x<x2; x++){
                    board[y][x] = 1; //직사각형이 만들어지는 곳은 1로 변경
                }
            }
        }
        solution();
        System.out.println(answer);
        Collections.sort(list);
        for(int i : list) System.out.print(i + " ");



    }
}