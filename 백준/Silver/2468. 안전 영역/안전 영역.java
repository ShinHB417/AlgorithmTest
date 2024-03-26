import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main{

    static int[][] board,visited;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int n;

    public static int solution(){

        int answer = 1;
        for(int d = 1; d<=100; d++){
            visited = new int[n][n];
            int cnt =0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(board[i][j] > d && visited[i][j] == 0){
                        cnt++;
                        DFS(i,j,d);

                    }
                }
                answer = Math.max(answer,cnt);
            }
        }
        return answer;

    }

    public static void DFS(int x, int y, int d){
        visited[x][y] = 1;
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx < 0 || nx >=n || ny <0 || ny >=n) continue;
            if(visited[nx][ny] == 0 && board[nx][ny] > d) DFS(nx,ny,d);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution());

    }

}
