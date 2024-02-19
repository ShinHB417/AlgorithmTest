import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
class Edge implements Comparable<Edge>{
    int dest, cost;

    public Edge(int dest, int cost){
        this.dest = dest;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}
public class Main {

    static ArrayList<ArrayList<Edge>> graph;

    static int[] dis;

    public static void BFS(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.dest;
            int nowCost = cur.cost;
            if(nowCost > dis[now]) continue;
            for(Edge e : graph.get(now)){
                if(dis[e.dest] > e.cost + nowCost){
                    dis[e.dest] = e.cost + nowCost;

                    pq.add(new Edge(e.dest, e.cost + nowCost));

                }
            }
        }

    }




    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()); // 도시의 개수
        int m = Integer.parseInt(br.readLine()); // 버스의 개수
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        graph = new ArrayList<>();

        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
        }
        st = new StringTokenizer(br.readLine());
        BFS(Integer.parseInt(st.nextToken()));
        System.out.println(dis[Integer.parseInt(st.nextToken())]);










    }
}
