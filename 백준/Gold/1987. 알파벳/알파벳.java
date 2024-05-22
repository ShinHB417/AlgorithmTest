import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static char[][] board;
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0,1,0,-1};

    static int row,col,answer = Integer.MIN_VALUE;
    public static void DFS(int l,int x, int y, String str){
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >=0 && nx < row && ny >=0 && ny < col && !str.contains(String.valueOf(board[nx][ny]))){
                DFS(l+1,nx,ny,str+board[nx][ny]);
            }
        }
        answer = Math.max(answer,l);
    }


    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());

        board = new char[row][col];
        for(int i = 0; i < row; i++){
            String str = br.readLine();
            for(int j = 0; j < col; j++){
                board[i][j] = str.charAt(j);
            }
        }
        DFS(1,0,0, String.valueOf(board[0][0]));
        System.out.println(answer);





    }
}
