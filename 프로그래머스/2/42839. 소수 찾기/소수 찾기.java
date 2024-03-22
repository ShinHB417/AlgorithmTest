import java.util.*;


class Solution {
    static char[] arr;
    static int[] checked;
    static HashSet<Integer> set = new HashSet<>();
    
    public static void DFS(int l, String answer, String numbers){
        if(l == arr.length){
            return;
        }else{
            for(int i = 0; i < numbers.length(); i++){
                if(checked[i] == 0){
                    checked[i] = 1;
                    set.add(Integer.parseInt(answer + numbers.charAt(i)));
                    DFS(l+1,answer+numbers.charAt(i),numbers);
                    checked[i] = 0;
                }
            }

            
        }
    }
    
    public boolean isPrime(int n){
        if(n == 0 || n == 1) return false;
        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }
        return true;
    }

    public int solution(String numbers) {
        
        arr = numbers.toCharArray();
        int answer = 0;
        checked = new int[numbers.length()];
        DFS(0,"",numbers);
        for(int i : set){
            System.out.print(i + "\n");
         if(isPrime(i)) answer++;    
        }
        
        return answer;
        
    }
}