import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;


public class Main{



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        List<String> list = new ArrayList<>();
        while(n-->0){
            String s = br.readLine();
            String num ="";
            for(char c : s.toCharArray()){
                if(Character.isDigit(c)){
                    num += c;
                }else{
                    if(!num.equals("")){
                        list.add(num);
                        num="";
                    }
                }
            }
            if(!num.equals("")) list.add(num);
        }

        List<String> nums = list.stream().map(num -> {
            while(!num.equals("0") && num.startsWith("0")){
                num = num.substring(1);
            }
            return num;
        }).collect(Collectors.toList());

        nums.sort(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                if(s1.length() == s2.length()){
                    return comp(s1,s2);
                }else{
                    return s1.length() - s2.length();
                }
            }

            private int comp(String o1, String o2) {
                int idx = 0;
                while (o1.length() > idx && o2.length() > idx) {
                    if (o1.charAt(idx) != o2.charAt(idx)) {
                        return o1.charAt(idx) - o2.charAt(idx);
                    } else {
                        idx++;
                    }
                }
                return 0;
            }

        });
        nums.forEach(System.out::println);




    }

}
