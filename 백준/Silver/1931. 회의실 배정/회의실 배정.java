import java.util.*;

class Meeting implements Comparable<Meeting>{
    int s,e;

    public Meeting(int s, int e){
        this.s = s;
        this.e = e;
    }
    @Override
    public int compareTo(Meeting o){
        if(this.e == o.e){
            //끝나는 시간 같을 때는
            return this.s - o.s;
        }else{
            return this.e - o.e;
            //this가 앞 -> 오름차순 ( this(나)가 앞에 있어야 오른다 라고 생각해 )
            //this가 뒤 -> 내림차순
        }

    }
}

public class Main {

    static ArrayList<Meeting> list = new ArrayList<>();
    static int answer;

    public static void Solution(){
        int e = 0;
        for(Meeting m : list){
            if(m.s >= e){
                answer++;
                e = m.e;
            }
        }
    }

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for(int i = 0; i< n; i++){
            int s = scan.nextInt();
            int e = scan.nextInt();
            list.add(new Meeting(s,e));
        }
        Collections.sort(list);
        Solution();
        System.out.println(answer);
    }
}