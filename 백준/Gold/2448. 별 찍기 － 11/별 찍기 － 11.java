import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    static char[][] board;

    public static void star(int x, int y, int size){
        if(size == 3){
            board[x][y] = '*';
            board[x + 1][y - 1] = board[x + 1][y + 1] = '*';
            board[x + 2][y - 2] = board[x + 2][y - 1] = board[x + 2][y] = board[x + 2][y + 1] = board[x + 2][y + 2] = '*';
        }else{
            star(x,y,size/2);
            star(x + size / 2, y - size / 2, size / 2);
            star(x + size / 2, y + size / 2, size / 2);
        }

    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        board = new char[n][2*n-1];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], ' ');
        }
        star(0,n-1,n);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2*n-1; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        System.out.println(sb);


    }
}