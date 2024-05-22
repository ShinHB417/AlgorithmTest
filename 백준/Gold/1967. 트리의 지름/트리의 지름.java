import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

class Node{
    int v, w;
    public Node(int v, int w){
        this.v = v;
        this.w = w;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> graph;
    static int[] checked;
    static int max = Integer.MIN_VALUE;

    static int first;
    public static void DFS(int start, int sum){
        if(sum >= max) {
            first = start;
            max = sum;
        }
        for(Node n : graph.get(start)){
            if(checked[n.v] == 0){
                checked[n.v] = 1;
                DFS(n.v, sum + n.w);
                checked[n.v] = 0;
            }

        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        checked = new int[n+1];
        for(int i = 0; i<=n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < n-1; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            graph.get(a).add(new Node(b,c));
            graph.get(b).add(new Node(a,c));
        }
        checked[1] = 1;
        DFS(1,0);
        max = Integer.MIN_VALUE;
        Arrays.fill(checked, 0);

        checked[first] = 1;
        DFS(first,0);
        int answer = max;
        System.out.println(answer);
    }
}
