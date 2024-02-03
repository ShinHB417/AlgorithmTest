import java.util.*;
class Point{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}


public class Main {

    static Point dest;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int[][] answer;
    static int row,col;
    public static void BFS(int x, int y){
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x,y));
        board[x][y] = 0;
        while(!q.isEmpty()){
            Point cur = q.poll();
                for(int k = 0; k < 4; k++){
                    int nx = cur.x + dx[k];
                    int ny = cur.y + dy[k];

                    if(nx >=0 && nx < row && ny >=0 && ny < col && board[nx][ny] == 1 ){
                        board[nx][ny] = 0;
                        q.add(new Point(nx,ny));
                        answer[nx][ny] = answer[cur.x][cur.y] + 1;
                    }
                }
        }
    }


    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        row = scan.nextInt();
        col = scan.nextInt();
        board = new int[row][col];
        answer = new int[row][col];

        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int a = scan.nextInt();
                if(a == 2){
                    dest = new Point(i,j);
                }
                board[i][j] = a;
            }
        }
        answer[dest.x][dest.y] = 0;
        BFS(dest.x, dest.y);

        for(int i = 0; i < answer.length; i++){
            for(int j = 0; j < answer[0].length; j++){
                if(board[i][j] == 1){
                answer[i][j] = -1;
            }
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}




