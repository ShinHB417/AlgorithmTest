import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Point{
    int x,y,type;
    public Point(int x, int y, int type){
        this.x = x;
        this.y = y;
        this.type = type;
    }
}


public class Main {
    //일자로 가려면 그 다음칸만 비어있으면 된다
    //대각선(오른쪽아래대각선) -> 현재위치기준 3곳

    static int[][] board;
    static int answer,n;

    public static void DFS(int x, int y, int type){
        if(x == n-1 && y == n-1){
            answer ++;
        }else{
            if(type ==1){
                int nx = x;
                int ny = y+1;
                if(nx < n && ny < n && board[nx][ny] == 0){
                    DFS(nx,ny,1);
                }
            }else if(type ==2){
                int nx = x+1;
                int ny = y;
                if(nx < n && ny < n && board[nx][ny] == 0){
                    DFS(nx,ny,2);
                }

            }else if(type ==3){
                int nx = x;
                int ny = y+1;
                if(nx < n && ny < n && board[nx][ny] == 0){
                    DFS(nx,ny,1);
                }

                nx = x+1;
                ny = y;
                if(nx < n && ny < n && board[nx][ny] == 0){
                    DFS(nx,ny,2);
                }
            }
            int nx = x+1;
            int ny = y+1;
            if(nx < n && ny < n && board[nx][ny] == 0 && board[nx][ny-1] == 0
             && board[nx-1][ny] == 0){
                DFS(nx,ny,3);
            }
        }


    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        DFS(0,1,1);

        System.out.println(answer);



    }

}