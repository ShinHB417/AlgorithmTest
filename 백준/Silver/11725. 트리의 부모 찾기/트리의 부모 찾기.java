import java.util.*;



public class Main {

    static ArrayList<ArrayList<Integer>> graph;
    static int[] answer, visited;

    public static void BFS(){
        Queue<Integer> q = new LinkedList<>();
        visited[1] = 1;
        q.add(1);
        while(!q.isEmpty()){
            int  i = q.poll();
            for(int x : graph.get(i)){
                if(visited[x] == 0){
                    answer[x] = i;
                    visited[x] = 1;
                    q.add(x);
                }

            }
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        graph = new ArrayList<>();
        int n = scan.nextInt();
        answer = new int[n+1];
        visited = new int[n+1];
        for(int i = 0; i <=n; i++){
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < n-1; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            graph.get(a).add(b);
            graph.get(b).add(a);
        }
        // 1 6 4
        // 2 4
        // 3 6 5
        // 4 1 2 7
        // 5 3
        // 6 1 3
        // 7 4
        BFS();
        for(int i = 2; i <=n; i++){
            System.out.println(answer[i]);
        }
    }
}




