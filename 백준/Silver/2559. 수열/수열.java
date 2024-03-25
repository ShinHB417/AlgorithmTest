import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] arr = new int[n + 1];
        int[] psum = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <=n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            psum[i] = psum[i-1] + arr[i];
        }
        int answer = Integer.MIN_VALUE;
        for(int i = k; i <=n; i++ ){
            answer = Math.max(answer, psum[i] - psum[i-k]);
        }
        System.out.println(answer);


    }

}
