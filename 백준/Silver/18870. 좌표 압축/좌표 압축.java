
import java.util.*;


public class Main {

    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n  = scan.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        for(int i = 0; i <n; i++){
            int a = scan.nextInt();
            list.add(a);
            list2.add(a);
        }

        Collections.sort(list);
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 0;
        for(int i : list){
            if(map.containsKey(i)){
                continue;
            }
            else{
                map.put(i,rank++);
            }
        }
        for(int i : list2){
            sb.append(map.get(i) + " ");
        }

        System.out.println(sb);

    }
}




