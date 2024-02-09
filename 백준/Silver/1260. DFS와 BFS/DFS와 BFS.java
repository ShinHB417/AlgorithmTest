import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static int[] visitedD, visitedB;
    static StringBuilder sb = new StringBuilder();
    public static void DFS(int start){
        for(int i : graph.get(start)){
            if(visitedD[i] == 0){
                sb.append(i + " ");
                visitedD[i] = 1;
                DFS(i);
            }
        }

    }

    public static void BFS(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visitedB[start] = 1;

        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i : graph.get(cur)){
                if(visitedB[i] == 0){
                    visitedB[i] = 1;
                    sb.append(i + " ");
                    q.add(i);
                }
            }
        }

    }
    static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new ArrayList<>();


        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 정점의개수
        int m = Integer.parseInt(st.nextToken()); // 간선개수
        int v = Integer.parseInt(st.nextToken()); // 시작점
        //양방향
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        visitedD = new int[n+1];
        visitedB = new int[n+1];

        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph.get(s).add(e);
            graph.get(e).add(s);
        }
        for(int i = 1; i<=n; i++){
            Collections.sort(graph.get(i));
        }
        visitedD[v] = 1;
        sb.append(v + " ");
        DFS(v);
        sb.append("\n");
        visitedB[v] = 1;
        sb.append(v + " ");
        BFS(v);
        System.out.println(sb);


    }


}