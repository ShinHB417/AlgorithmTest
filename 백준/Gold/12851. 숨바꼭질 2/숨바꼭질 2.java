import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int n,k,l=1,answer=Integer.MAX_VALUE,cnt;
    static boolean[] check;

    static int[] time = new int[100001];
    public static void BFS(){
        if(n == k){
            System.out.println(0 + "\n" + 1);
            return;
        }
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        time[n]  = 1;
        while(!q.isEmpty()){

                int cur = q.poll();

                if(answer < time[cur]) return;
                for(int j = 0; j < 3; j++){
                    int nx;
                    if(j ==0){
                        nx = cur+1;
                    }else if(j==1){
                        nx = cur-1;
                    }else{
                        nx = cur*2;
                    }
                    if(nx == k){
                        answer = time[cur];
                        cnt++;
                    }
                    if(nx < 0 || nx > 100000) continue;
                    if(time[nx] == 0 || time[nx] == time[cur] + 1){
                        q.add(nx);
                        time[nx] = time[cur] + 1;
                    }

                }


        }


    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        if(n >= k) {
            System.out.println(n-k);
            System.out.println(1);
            return;
        }
        check = new boolean[100001];
        BFS();
        System.out.println(answer + "\n" + cnt);


    }
}