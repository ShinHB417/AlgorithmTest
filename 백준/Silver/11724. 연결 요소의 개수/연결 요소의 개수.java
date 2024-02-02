
import java.util.*;


public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] visited;
    public static void DFS(int n){
        visited[n] = 1;
        for(int v : graph.get(n)){
            if(visited[v] == 0){
                visited[v] = 0;
                DFS(v);
            }
        }
    }



    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        graph = new ArrayList<>();
        int answer = 0;
        int n = scan.nextInt();
        int m = scan.nextInt();
        visited = new int[n+1];
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<Integer>());
        }

        for(int i = 0 ; i < m; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            if(visited[i] == 0){
                DFS(i);
                answer++;
            }
        }
        System.out.println(answer);
        }



    }




