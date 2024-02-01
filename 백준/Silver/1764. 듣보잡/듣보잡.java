
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int n = scan.nextInt();
        int m = scan.nextInt();
        scan.nextLine();
        HashSet<String> set = new HashSet<>();

        for(int i = 0; i< n; i++){
            set.add(scan.nextLine().trim());
        }
        int answer = 0;
        ArrayList<String> answerList = new ArrayList<>();
        for(int i = 0; i<m; i++){
            String s = scan.nextLine();
            if(set.contains(s)){
                answer++;
                answerList.add(s);
            }
        }
        Collections.sort(answerList);
        System.out.println(answer);
        for(String s : answerList) System.out.println(s);

    }


}


