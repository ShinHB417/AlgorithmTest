import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static int n,m;
    static HashMap<Integer,Integer> map;

    static boolean[] visited;

    public static int BFS(){
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        int l = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                int cur = q.poll();
                for(int j = 1; j <=6; j++){
                    int nx = cur + j;
                    if(nx > 100) continue;
                    if(nx == 100) return l;
                    if(map.containsKey(nx)){
                        if(visited[map.get(nx)] == false){
                            visited[map.get(nx)] = true;
                            q.add(map.get(nx));
                        }
                    }else{
                        if(visited[nx] == false){
                            visited[nx] = true;
                            q.add(nx);
                        }

                    }
                }
            }
            l++;
        }
        return l;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // 사다리 수
        m = Integer.parseInt(st.nextToken()); // 뱀 수
        map = new HashMap<>();
        visited = new boolean[101];


        for(int i = 0; i < n + m; i ++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map.put(a,b);
        }

        int answer =BFS();

        System.out.println(answer);

    }
}
