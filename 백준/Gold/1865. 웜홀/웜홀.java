import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class edge{
    int dest, cost;
    public edge(int dest, int cost){
        this.dest= dest;
        this.cost = cost;
    }
}
public class Main {
    static int n,m,w;
    static final int INF = 99999999;

    static ArrayList<ArrayList<edge>> graph;
    static int[] dis;

    public static boolean bf(int start, int n){
        Arrays.fill(dis, INF);
        dis[start] = 0;
        boolean update = false;
        //n-1번 라운드 반복
        for(int i = 1; i <n; i++){
            update = false;

            for(int j = 1; j <=n; j++){
                for(edge e : graph.get(j)){
                    if(dis[j] != INF && dis[j] + e.cost < dis[e.dest]){
                        dis[e.dest] = dis[j] + e.cost;
                        update = true;
                    }
                }
            }
            if(!update) break;
        }
        //위 과정을 한번 더 수행
        if(update){
            for(int j = 1; j <=n; j++){
                for(edge e : graph.get(j)){
                    if(dis[j] != INF && dis[j] + e.cost < dis[e.dest]){
                        return true;
                    }
                }
            }
        }
        return false;

    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int tc = Integer.parseInt(br.readLine()); //테스트케이스 개수
        

        for(int i = 0; i<tc; i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //지점의 개수
            dis = new int[n+1];
            graph = new ArrayList<>();
            for(int k = 0; k <= n; k++){
                graph.add(new ArrayList<>());
            }

            m = Integer.parseInt(st.nextToken()); // 도로의 개수
            w = Integer.parseInt(st.nextToken()); // 웜홀의 개수

            for(int j = 0; j < m; j++){
                //도로 입력 받음
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.get(s).add(new edge(e,t));
                graph.get(e).add(new edge(s,t));
            }

            for(int l = 0; l <w; l++){
                //웜홀 입력받음
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());

                graph.get(s).add(new edge(e,-t));
            }
            boolean flag = false;
            for(int o = 1; o <=n; o++){
                flag = bf(o,n);
                if(flag) break;
            }
            if(flag) sb.append("YES" + "\n");
                else sb.append("NO" + "\n");
        }
        System.out.println(sb);
        br.close();

    }

}