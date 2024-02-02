
import java.util.*;


public class Main {
    static int[] visited;
    public static int BFS(int n, int k){
        if(n ==k) return 0;
        Queue<Integer> q = new LinkedList<>();
        visited[n] = 1;
        q.add(n);
        int l = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i <size; i++){
                int cur = q.poll();
                for(int j = 0; j < 3; j++){
                    int nx;
                    if(j == 0){
                        nx = cur +1;
                    }else if(j ==1){
                        nx = cur -1;
                    }else{
                        nx = cur *2;
                    }
                    if(nx == k){
                        return l+1;
                    }
                    if(nx >= 0 && nx <=100000 && visited[nx] == 0){
                        q.add(nx);
                        visited[nx] = 1;
                    }
                }
            }
            l++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        int k = scan.nextInt();
        visited = new int[100001];

        System.out.println(BFS(n,k));
    }
}




