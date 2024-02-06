import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
class Person implements Comparable<Person>{
    int x,time;
    public Person(int x, int time){
        this.x = x;
        this.time = time;
    }
    @Override
    public int compareTo(Person p){
        return this.time - p.time;
    }
}


public class Main {
    static int[] visited;

    public static void BFS(int s, int e){
        PriorityQueue<Person> pq = new PriorityQueue<>();
        visited[s] = 1;
        pq.add(new Person(s,0));

        while(!pq.isEmpty()){
            Person cur = pq.poll();
            visited[cur.x] = 1;
            if(cur.x == e) {
                System.out.println(cur.time);
                return;
            }
            int nx = cur.x * 2;
            if(nx <=100000 && visited[nx] == 0){
                pq.add(new Person(nx,cur.time));

            }
            
            nx = cur.x +1;
            if(nx >=0 && nx <=100000 && visited[nx] == 0){
                pq.add(new Person(nx, cur.time+1));
            }
            nx = cur.x -1;
            if(nx >=0 && nx <=100000 && visited[nx] == 0){
                pq.add(new Person(nx, cur.time+1));
            }

        }

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        BFS(n,m);

    }

}