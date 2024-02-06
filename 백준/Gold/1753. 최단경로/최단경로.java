import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class edge implements Comparable<edge>{
    int vex,weight;
    public edge(int vex, int weight){
        this.vex = vex;
        this.weight = weight;
    }

    @Override
    public int compareTo(edge e){
        return this.weight - e.weight;
    }
}


public class Main {
    static ArrayList<ArrayList<edge>> graph;
    static int[] dis;

    static void solution(int start){
        PriorityQueue<edge> pq = new PriorityQueue<>();
        pq.add(new edge(start,0));
        dis[start]= 0;

        while(!pq.isEmpty()){
            edge cur = pq.poll();
            int now = cur.vex;
            int nowWeight = cur.weight;
            for(edge e : graph.get(now)){
                if(dis[e.vex] > nowWeight +e.weight){
                    dis[e.vex] = nowWeight + e.weight;

                    pq.add(new edge(e.vex, nowWeight + e.weight));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int v = Integer.parseInt(st.nextToken()); // 정정믜 개수
        int e = Integer.parseInt(st.nextToken()); // 엣지 개수
        int k = Integer.parseInt(br.readLine()); // 시작 vex

        graph = new ArrayList<>();
        dis = new int[v+1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        for(int i = 0; i <=v; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < e; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(s).add(new edge(a,w));
        }

        solution(k);
        for(int i = 1; i <=v; i++){
            if(dis[i] == Integer.MAX_VALUE) System.out.println("INF");
            else System.out.println(dis[i]);
        }






    }

}