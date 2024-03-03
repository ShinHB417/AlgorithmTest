import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Edge implements Comparable<Edge>{
    int vex, cost;

    public Edge(int vex, int cost){
        this.vex = vex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge e){
        return this.cost - e.cost;
    }


}
public class Main {

    static ArrayList<ArrayList<Edge>> graph;
    static int v,e,answer;
    static boolean[] check;
    public static void prim(){
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));

        while(!pq.isEmpty()){
            Edge cur = pq.poll();
            int curVex = cur.vex;
            int curCost = cur.cost;
            if(check[curVex] == false){
                //여기서 확정
                check[curVex] = true;
                answer+= curCost;
                for(Edge e : graph.get(curVex)){
                    if(check[e.vex] != true){
                        pq.add(e);
                    }
                }
            }
        }

    }



    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        v = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        check = new boolean[v+1];
        graph = new ArrayList<>();
        for(int i = 0; i <=v; i++){
            graph.add(new ArrayList<>());
        }

        while(e-->0){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Edge(b,c));
            graph.get(b).add(new Edge(a,c));
        }

        prim();
        System.out.println(answer);








    }
}