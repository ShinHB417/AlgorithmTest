import java.util.*;
class set{
    int x,y;
    public set(int x, int y){
        this.x = x;
        this.y = y;
    }
}
class Solution {
    static ArrayList<set> list =new ArrayList<>();
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;
        for(int i = 1; i <=Math.sqrt(yellow); i++){
            if(yellow%i == 0){
                list.add(new set(i,yellow/i));
            }
        }
        for(set s : list){
            if((s.x+2) * (s.y+2) == total){
                answer[0] = s.y+2;
                answer[1] = s.x+2;
            }
        }
        return answer;
       
    }
}