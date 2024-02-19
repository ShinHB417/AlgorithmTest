import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Main {

    static long s,e;
    static boolean flag = false;

    public static int BFS(){
        Queue<Long> q = new LinkedList<>();
        q.add(s);
        int l = 1;
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                long cur = q.poll();
                for(int j = 0; j < 2; j++){
                    long nx;
                    if(j ==0){
                        nx = cur * 2;
                    }else{
                        nx = cur * 10 + 1;
                    }


                    if(nx > e) continue;
                    if(nx == e){
                        flag = true;
                        return l;
                    }
                    q.add(nx);
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
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());


        int answer = BFS();
        if(flag == false) System.out.println(-1);
        else System.out.println(answer+1);








    }
}
