class Solution {
    static int answer = 0;
    
    public static void DFS(int idx, int sum, int[] numbers, int target){
        if(idx == numbers.length){
            if(sum == target){
                answer++;
                return;
            }
        }else{
            DFS(idx+1, sum + numbers[idx], numbers, target);
            DFS(idx+1, sum  - numbers[idx], numbers, target);
        }
    }
    public int solution(int[] numbers, int target) {
        
        DFS(0,0,numbers,target);
        return answer;
    }
}