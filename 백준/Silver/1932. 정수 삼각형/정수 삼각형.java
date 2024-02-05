import java.util.*;



public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> dp = new ArrayList<>();

        scan.nextLine();

        for(int i = 0; i < n; i++){
            arr.add(new ArrayList<>());
            dp.add(new ArrayList<>());
        }
        for(int i = 0; i < n; i++){
            String[] s = scan.nextLine().split(" ");
            for(int j = 0; j < s.length; j++){
                arr.get(i).add(Integer.parseInt(s[j]));
            }
        }
        dp.get(0).add(arr.get(0).get(0));

        for(int i = 1; i<n; i++){
            for(int j = 0; j <i+1; j++){
                if(j == 0){
                    dp.get(i).add(arr.get(i).get(j) + dp.get(i-1).get(j));
                }else if(j == i){
                    dp.get(i).add(arr.get(i).get(j) + dp.get(i-1).get(j-1));
                }else{
                    dp.get(i).add(arr.get(i).get(j) + Math.max(dp.get(i-1).get(j-1), dp.get(i-1).get(j)));
                }
            }
        }
        int max = 0;
        for(int i : dp.get(n-1)){
            max = Math.max(max, i);
        }
        System.out.println(max);

    }
}




