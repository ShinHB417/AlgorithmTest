
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n  = scan.nextInt(); // 몬스터 수
        int m = scan.nextInt(); // 문제 수

        HashMap<Integer, String> map1 = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        scan.nextLine();
        for(int i = 1; i <= n; i++){
            String name = scan.nextLine();
            map1.put(i, name);
            map2.put(name, i);
        }

        for(int i = 0; i < m; i++){
            String str = scan.nextLine();

            if(Character.isDigit(str.charAt(0))){
                // 숫자 들어오면 문자열로 반환
                // 숫자, 문자열 구조
                sb.append(map1.get(Integer.parseInt(str)) + "\n");
            }else{
                sb.append(map2.get(str) + "\n");
            }
        }
        System.out.println(sb);
    }


}


