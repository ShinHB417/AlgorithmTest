import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge>{
    int v, cost;
    public Edge(int v, int cost){
        this.v = v;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}

public class Main {

    static int n,e,answer1, answer2;
    static int[] dis;
    static final int  INF = 200000000;

    public static void dijkstra(int start){
        Arrays.fill(dis, INF);
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        dis[start] = 0;

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.v;
            int nowCost = cur.cost;

            if(dis[now] < nowCost) continue;
            for(Edge e :graph.get(now)){
                if(dis[e.v] > nowCost + e.cost ){
                    dis[e.v] = nowCost + e.cost;
                    pq.add(new Edge(e.v,nowCost+e.cost));
                }
            }
        }

    }

    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 정점의 개수
        e = Integer.parseInt(st.nextToken()); // 간선의 개수
        graph = new ArrayList<>();
        dis = new int[n+1];


        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        while(e -- >0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }
        int[] must = new int[2];
        st = new StringTokenizer(br.readLine());
        must[0] = Integer.parseInt(st.nextToken());
        must[1] = Integer.parseInt(st.nextToken());

        dijkstra(1);
        if(dis[must[0]] == INF){
            System.out.println(-1);
            return;
        }
        answer1 += dis[must[0]];
        dijkstra(must[0]);
        if(dis[must[1]] == INF){
            System.out.println(-1);
            return;
        }
        answer1 += dis[must[1]];
        dijkstra(must[1]);
        if(dis[n] == INF){
            System.out.println(-1);
            return;
        }
        answer1 += dis[n];

        dijkstra(1);
        if(dis[must[1]] == INF){
            System.out.println(-1);
            return;
        }
        answer2 += dis[must[1]];
        dijkstra(must[1]);
        if(dis[must[0]] == INF){
            System.out.println(-1);
            return;
        }
        answer2 += dis[must[0]];
        dijkstra(must[0]);
        if(dis[n] == INF){
            System.out.println(-1);
            return;
        }
        answer2 += dis[n];

        System.out.println(Math.min(answer1,answer2));

    }

}