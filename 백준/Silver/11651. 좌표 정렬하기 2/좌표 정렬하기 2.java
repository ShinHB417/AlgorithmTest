import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point p){
        if(this.y == p.y){
            return this.x - p.x;
        }else{
            return this.y - p.y;
        }
    }
}
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Point> list = new ArrayList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        Collections.sort(list);
        for(Point p : list){
            System.out.println(p.x + " " + p.y);
        }
    }

}