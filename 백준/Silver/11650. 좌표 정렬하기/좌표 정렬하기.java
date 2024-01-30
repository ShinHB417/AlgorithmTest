import java.io.*;
import java.util.*;
class Point implements Comparable<Point>{
    int x,y;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }
    @Override
    public int compareTo(Point p){
        if(p.x == this.x){
            return this.y - p.y;
        }else{
            return this.x - p.x;
        }
    }

}
public class Main {
    public static void main(String[] args){
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        ArrayList<Point> list = new ArrayList<>();
        int n = scan.nextInt();
        for(int i = 0; i<n; i++){
            int a = scan.nextInt();
            int b = scan.nextInt();

            list.add(new Point(a,b));
        }
        Collections.sort(list);
        for(Point p : list) System.out.println(p.x + " " + p.y);

    }


}


