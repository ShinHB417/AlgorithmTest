import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        //BufferedReader -> :Scanner와 유사.

        //Bufferedwriter -> System.out.println();과 유사

        //StringTokenizer - >  split()과 유사


        //Scanner scan = new Scanner(System.in);
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
                    bw.write(list.get(list.size()-1) + "\n");
                    list.remove(list.size()-1);
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

            }else if(cmd[0].equals("top")){
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