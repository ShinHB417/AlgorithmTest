class Solution {
    static int[] visited;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new int[n];
        for(int i = 0; i<n; i++){
            if(visited[i] == 0){
                answer++;
                DFS(n,computers, i);
            }
        }
        return answer;
    }
    
    public static void DFS(int n, int[][] computers,int v){
        visited[v] = 1;
        for(int i = 0; i< n ; i++){
            if(visited[i] == 0 && computers[v][i] == 1){
                DFS(n,computers,i);
            }
        }
    }
}