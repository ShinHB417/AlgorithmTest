import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main{

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> order = new HashMap<>();
        ArrayList<int[]> list = new ArrayList<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            if (!map.containsKey(number)) {
                map.put(number, 1);
                order.put(number, i);
            } else {
                map.put(number, map.get(number) + 1);
            }
        }

        for(int k : map.keySet()){
            list.add(new int[]{map.get(k),k});
        }

        list.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]){
                    return order.get(o1[1]) - order.get(o2[1]);
                }else{
                    return o2[0] - o1[0];
                }
            }
        });
        for (int[] arr : list) {
            while (arr[0]-- > 0) {
                System.out.print(arr[1] + " ");
            }
        }



    }

}
