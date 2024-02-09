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

    static char[][] board;
    static int row,col,sx,sy, answer;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    public static void BFS(int sx, int sy){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sx,sy));
        board[sx][sy] = 'X';
        while(!q.isEmpty()){

            Point cur = q.poll();

            for(int i = 0; i < 4; i++){
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if(nx >=0 && nx <row && ny >=0 && ny <col && board[nx][ny] !='X'){
                    if(board[nx][ny] == 'P') answer++;
                    board[nx][ny] = 'X';
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

        board = new char[row][col];

        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                char c = str.charAt(j);
                if(c == 'I'){
                    sx = i;
                    sy = j;
                }

                board[i][j] = c;
            }
        }
        BFS(sx,sy);
        if(answer > 0){
            System.out.println(answer);
        }else{
            System.out.println("TT");
        }

    }


}