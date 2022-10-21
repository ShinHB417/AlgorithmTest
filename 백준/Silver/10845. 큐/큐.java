import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        //int num = scan.nextInt();
        int num = Integer.parseInt(br.readLine());

        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i <num; i++){

            String str = br.readLine();

            String[] cmd = str.split(" ");

            if(cmd[0].equals("push")){
                list.add(cmd[1]);

            }else if(cmd[0].equals("pop")){
                if(list.isEmpty()){
                    //System.out.println(-1);
                    bw.write(-1 + "\n");
                }else{
                    //System.out.println(list.get(list.size()-1));
                    bw.write(list.get(0) + "\n");
                    list.remove(0);
                }


            }else if(cmd[0].equals("size")){
                //System.out.println(list.size());
                bw.write(list.size()+ "\n");

            }else if(cmd[0].equals("empty")){
                if(list.isEmpty()){
                    //System.out.println(1);
                    bw.write(1+ "\n");
                }else{
                    //System.out.println(0);
                    bw.write(0+ "\n");
                }

            }else if(cmd[0].equals("front")){
                if(list.isEmpty()){
                    //System.out.println(-1);
                    bw.write(-1+ "\n");
                }else{
                    //System.out.println(list.get(list.size()-1));
                    bw.write(list.get(0)+ "\n");
                }


            }else if(cmd[0].equals("back")){
                if(list.isEmpty()){
                    //System.out.println(-1);
                    bw.write(-1+ "\n");
                }else{
                    //System.out.println(list.get(list.size()-1));
                    bw.write(list.get(list.size()-1)+ "\n");
                }


            }
        }


        bw.flush(); //버퍼에 있는거 한번에 출력해낸다
        bw.close();


    }
}