import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //유저 수
        int m = Integer.parseInt(st.nextToken()); //관계 수
        int[][] graph = new int[n+1][n+1];
        int[] dis = new int[n+1];

        for(int i = 1; i <=n; i++){
            for(int j = 1; j <=n; j++){
                graph[i][j] = 5555;
                if(i == j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = graph[b][a] = 1;
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    // 최단경로 초기화
                    if (graph[i][j] > (graph[i][k] + graph[k][j])) {
                        //(graph[i][k] + graph[k][j]) 이 부분에서 INT 오버플로우가 일어나게 됨
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }

        for(int i = 1; i<=n; i++){
            int sum = 0;
            for(int j = 1; j <=n; j++){
                sum += graph[i][j];
            }
            dis[i] = sum;
        }
        int min = Integer.MAX_VALUE;
        int answer = 0;
        for(int i = 1; i<=n; i++){
            if(min > dis[i]){
                min = dis[i];
                answer = i;
            }
        }
        System.out.println(answer);




    }

}