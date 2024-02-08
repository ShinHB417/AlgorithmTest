import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
class edge{
    int dest,cost;
    public edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
}
public class Main {
    static int max = Integer.MIN_VALUE;
    static int[] visited;
    static int vex;
    public static void DFS(int start, int sum){
        if(sum > max){
            max = sum;
            vex = start;
        }
        visited[start] = 1;
        for(edge e : graph.get(start)){
            if(visited[e.dest] == 0){
                visited[e.dest] = 1;
                DFS(e.dest, sum +e.cost);
            }
        }

    }

    static ArrayList<ArrayList<edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        graph = new ArrayList<>();

        int v = Integer.parseInt(br.readLine());//정점의 개수
        visited = new int[v+1];
        for(int i = 0; i <=v; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i<v; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            while(true){
                int dest = Integer.parseInt(st.nextToken());
                if(dest == -1) break;
                int cost = Integer.parseInt(st.nextToken());
                graph.get(s).add(new edge(dest,cost));
            }

        }
        DFS(1,0);
        Arrays.fill(visited,0);
        DFS(vex,0);
        System.out.println(max);

        }



    }
