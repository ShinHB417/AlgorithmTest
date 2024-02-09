import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {

    static int[] arr;
    static int n,m;
    public static long checkLength(int pos){
        long sum = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > pos){
                sum+= arr[i] - pos;
            }
        }
        return sum;
    }

    public static int solution(){
        int mid;
        int answer = 0;
        int lt = 0;
        int rt = Arrays.stream(arr).max().getAsInt();

        while(lt <= rt){
            mid = (lt + rt) /2;
            if(checkLength(mid) >= m ){
                lt = mid+1;
                answer = mid;
            }else{
                rt = mid-1;
            }
        }
        return answer;
    }


    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            // 20 15 10 17
        }
        System.out.println(solution());

    }


}