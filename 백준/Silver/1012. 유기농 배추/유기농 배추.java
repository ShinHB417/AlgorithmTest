
import java.util.*;


public class Main {
    //12시부터 시계방향
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};
    static int[][] board;
    static int answer;
    static StringBuilder sb = new StringBuilder();
    static int n,m;

    public static void solution(){
        answer = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i][j] == 1){
                    answer++;
                    DFS(i,j);
                }
            }
        }
        sb.append(answer + "\n");
    }

    public static void DFS(int x , int y){
        board[x][y] = 0;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >=0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 1){
                board[nx][ny] = 0;
                DFS(nx,ny);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt(); // 테스트 케이스

        for(int i = 0; i <t; i++){
             answer = 0;
             n = scan.nextInt();
             m = scan.nextInt();
            int k = scan.nextInt();

            board = new int[n][m];

            for(int j = 0; j<k; j++){
                    int a = scan.nextInt();
                    int b = scan.nextInt();
                    board[a][b] = 1;
            }
            solution();
        }
        System.out.println(sb);
    }


}



