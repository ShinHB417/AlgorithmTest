import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine()); // 테스트 케이스의 수

        while(tc-- > 0) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            int n = Integer.parseInt(br.readLine()); // 연산의 개수

            for(int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                if(op == 'I') {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if(!map.isEmpty()) {
                        if(num == 1) {
                            // 최댓값 삭제
                            int a = map.lastKey();
                            if(map.get(a) == 1) {
                                map.remove(a);
                            } else {
                                map.put(a, map.get(a) - 1);
                            }
                        } else {
                            // 최솟값 삭제
                            int a = map.firstKey();
                            if(map.get(a) == 1) {
                                map.remove(a);
                            } else {
                                map.put(a, map.get(a) - 1);
                            }
                        }
                    }
                }
            }

            if(map.size() == 0) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
        }

        System.out.print(sb);
    }
}
