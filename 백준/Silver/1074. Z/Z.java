
import java.util.*;


public class Main {
    static int[][] board;
    static int cnt = 0;


    public static void DFS(int size, int x , int y){
        if(size ==1){
            System.out.println(cnt);
            return;
        }else{
            int newSize = size/2;
            if(x < newSize && y >= newSize){
                //1사분면
                cnt += (size * size / 4);
                DFS(newSize,x,y - newSize);
            }else if(x < newSize && y < newSize){
                //2사분면
                DFS(newSize,x,y);
            }else if(x >= newSize && y < newSize){
                //3사분면
                cnt += (size * size / 4) * 2;
                DFS(newSize,x-newSize,y);
            }else{
                //4사분면
                cnt += (size * size / 4) * 3;
                DFS(newSize,x-newSize,y-newSize);
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = scan.nextInt();
        int size = (int) Math.pow(2,n);
        int x = scan.nextInt();
        int y = scan.nextInt();

        DFS(size,x,y);
    }
}




