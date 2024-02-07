import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine()); // 도시 개수
        int m = Integer.parseInt(br.readLine()); // 버스 개수

        int[][] graph = new int[n+1][n+1];
        for(int i = 1; i <=n; i++){
            for(int j = 1; j<=n; j++){
                graph[i][j] = 99999999;
                if(i == j) graph[i][j] = 0;
            }
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            // 1 2 2 -> 1번도시에서 2번도시 가는데 필요한 비용2
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(graph[r][c] > w){
                graph[r][c] = w;
            }
        }

        for(int k = 1; k <=n; k++){
            for(int i = 1; i<=n; i++){
                for(int j=1; j<=n; j++){
                    if(graph[i][j] > graph[i][k] + graph[k][j]){
                        graph[i][j] = graph[i][k] + graph[k][j];
                    }
                }
            }
        }
        for(int i = 1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(graph[i][j] == 99999999) sb.append(0 + " ");
                else sb.append(graph[i][j] + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }

}