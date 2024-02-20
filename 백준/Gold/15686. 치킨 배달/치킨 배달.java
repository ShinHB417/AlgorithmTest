import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Point{
    int x,y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int[][] board;

    static ArrayList<Point> chicken;
    static ArrayList<Point> house;
    static Point[] combi;

    static int n,m;
    static int answer =Integer.MAX_VALUE;

    public static void DFS(int l, int start){
        if(l == m){
            int sum = 0;
            for(Point h : house){
                int min = Integer.MAX_VALUE;
                for(Point c : combi){
                    min = Math.min(min,Math.abs(h.x - c.x) + Math.abs(h.y - c.y));
                }
                sum +=min;
            }
        answer = Math.min(answer, sum);
        }else{
            for(int i = start; i < chicken.size(); i++){
                combi[l] = chicken.get(i);
                DFS(l+1,i+1);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        board = new int[n][n];
        combi = new Point[m];
        for(int i = 0; i < n; i ++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n ; j ++){
                board[i][j] = Integer.parseInt(st.nextToken());
                if(board[i][j] == 1) house.add(new Point(i,j));
                if(board[i][j] == 2) chicken.add(new Point(i,j));
            }
        }
        DFS(0,0);
        System.out.println(answer);

    }

}