import java.util.*;


class Solution {
    static int[] visited;
    
    
public static boolean match(String s1, String s2){
    int diffCount = 0;
    for(int i = 0; i < s1.length(); i++){
        if(s1.charAt(i) != s2.charAt(i)) {
            diffCount++;
            if (diffCount > 1) // 한 글자만 다른 경우가 아니라면 바로 false 반환
                return false;
        }
    }
    return diffCount == 1; // 한 글자만 다른 경우에만 true 반환
}
    
    public static int bfs(String begin, String target,String[] words){
        Queue<String> q = new LinkedList<>();
        q.add(begin);
        int l  = 0;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i<len; i++){
                String cur = q.poll();
                System.out.println("23 cur :" + cur);
                for(int j = 0; j < words.length; j++){
                    if(cur.equals(target)) return l;
                    System.out.println("26 cur :" + cur + " words[j] : " +words[j]);
                    System.out.println(match(cur,words[j]));
                    if(match(cur, words[j])){
                        if(visited[j] != 1){
                            visited[j] = 1;
                            q.add(words[j]);
                        }
                    }
                }
                for(String s : q){
                    System.out.println(s);
                }
            }
            l++;
        }
        return l;
    }
    
    public int solution(String begin, String target, String[] words) {
        visited = new int[words.length];
        List<String> strList = new ArrayList<>(Arrays.asList(words));
        if(!strList.contains(target)) return 0; 
        return bfs(begin, target, words);
        
    }
}