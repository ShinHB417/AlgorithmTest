
import java.util.*;


public class Main {
    static ArrayList<ArrayList<Integer>> graph;
    static int answer;
    static int[] visited;
    public static void DFS(int s){
        visited[s] = 1;
        for(int i : graph.get(s)){
            if(visited[i] == 0){
                answer++;
                visited[i] = 1;
                DFS(i);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);

        int n = scan.nextInt(); // 컴퓨터 수 = 노드 수
        int m = scan.nextInt(); // 엣지 수
        visited = new int[n+1];
        // 0 1 2 3 4 5 6 7
        graph = new ArrayList<ArrayList<Integer>>();
        // 1 2 5
        // 2 1 3 5
        // 3 2
        // 4 7
        // 5 1 2 6
        // 6 5
        // 7 4
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        DFS(1);
        System.out.println(answer);





    }
}



