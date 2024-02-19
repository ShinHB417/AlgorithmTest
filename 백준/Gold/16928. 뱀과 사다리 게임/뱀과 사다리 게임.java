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
        visited[1] = true;
        int l = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int j = 0; j < len; j++){
                int cur = q.poll();
                for(int i = 1; i<=6; i++){
                    int nx = cur + i;
                    if(nx == 100) return l;
                    if(nx  > 100) continue;
                    if(visited[nx] == true) continue;

                    visited[nx] = true;
                    if(map.containsKey(nx)){
                        //사다리에 있을 때
                        q.add(map.get(nx));
                    }else{
                        //아무것도 없을 때
                        q.add(nx);
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
        n = Integer.parseInt(st.nextToken()); // 사다리
        m = Integer.parseInt(st.nextToken()); // 뱀
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
