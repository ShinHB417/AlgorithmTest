import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int e,cost;
    public Edge(int e, int cost){
        this.e = e;
        this.cost = cost;
    }
    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }
}
public class Main {
    static int n,m,x;
    static int answer =0;
    static ArrayList<ArrayList<Edge>> graph;


    public static int[] solution(int start){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        int[] dis = new int[n+1];
        Arrays.fill(dis,Integer.MAX_VALUE);
        dis[start] = 0;
        pq.add(new Edge(start,0));
        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int now = cur.e;
            int nowCost = cur.cost;
            if(nowCost > dis[now]) continue;
            for(Edge eg : graph.get(now)){
                if(nowCost + eg.cost < dis[eg.e]){
                    dis[eg.e] = nowCost + eg.cost;
                    pq.add(new Edge(eg.e, nowCost + eg.cost));
                }
            }
        }
        return dis;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //n명 학생
        m = Integer.parseInt(st.nextToken()); // m개의 도로
        x = Integer.parseInt(st.nextToken()); //목적지 x
        graph= new ArrayList<>();



        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i <m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
        }

        int[] dis1 = solution(x);

        for(int i =1 ; i <=n; i++){
            if(i == x) continue;
            int[] dis2 = solution(i);
            answer = Math.max(answer,dis1[i] + dis2[x]);
        }

        System.out.println(answer);

    }

}