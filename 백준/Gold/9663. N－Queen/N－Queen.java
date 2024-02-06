import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static int[] arr;
    public static int N;
    public static int count = 0;

    public static void nQueen(int depth) {
        // 모든 원소를 다 채운 상태면 count 증가 및 return
        if (depth == N) {
            count++;
        }else{
            for (int i = 0; i < N; i++) {
                arr[depth] = i;
                // 놓을 수 있는 위치일 경우 재귀호출
                if (Possibility(depth)) {
                    nQueen(depth + 1);
                }
            }
        }
    }

    public static boolean Possibility(int depth) {
        for(int i = 0; i<depth; i++){
            if(arr[i] == arr[depth]){
                return false;
            }
        }
        for(int i = 0; i<depth; i++){
            if(Math.abs(i-depth)==Math.abs(arr[i] - arr[depth])){
                return false;
            }
        }
        return true;

    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        nQueen(0);
        System.out.println(count);

    }


}