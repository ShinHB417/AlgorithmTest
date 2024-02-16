import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Point{
    int x;
    String result;
    public Point(int x, String result){
        this.x = x;
        this.result = result;
    }
}
public class Main {
    static char[] arr = {'D', 'S', 'L', 'R'};
    static int[] visited;

    public static int change(int n, char c){

        if(c == 'D'){
            n*=2;
            if(n > 9999){
                n = n % 10000;
            }

        }else if(c == 'S'){
            n-=1;
            if(n == -1) n = 9999;

        }else if(c == 'L'){
            int x = n / 1000;
            n = (n - (1000*x)) * 10 + x;

        }else if(c == 'R'){
            int x =  n % 10;
            n = (n - x) / 10 + x * 1000;
        }
        return n;
    }

    public static String BFS(int start , int dest){
        Queue<Point> q = new LinkedList<>();
        visited = new int[10001];
        visited[start] = 1;
        q.add(new Point(start, ""));

        while(!q.isEmpty()){

            Point cur = q.poll();

            for(int i = 0; i < 4; i++){

                int x = change(cur.x,arr[i]);
                if(x == dest) return cur.result + arr[i];
                if(visited[x] == 0){
                    visited[x] = 1;
                    q.add(new Point(x,cur.result + arr[i]));
                }

            }
        }
        return "";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 수


        while(tc-- > 0) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int dest = Integer.parseInt(st.nextToken());

            sb.append(BFS(start, dest) + "\n");

        }
        System.out.println(sb);
        br.close();


    }
}
