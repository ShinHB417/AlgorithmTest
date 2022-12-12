import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scan = new Scanner(System.in);
        int loop = scan.nextInt();
        double[] list = new double[loop];

        for(int i = 0; i<loop; i++){
            list[i] = scan.nextInt();
        }
        double max = CalMax(list);


        double sum = 0;
        for(int i = 0; i<loop; i++){
            list[i] = list[i]/max*100;
            sum+=list[i];
        }

        System.out.println(sum/ list.length);




    }

    public static double CalMax(double[] arr){
        double max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(max < arr[i]){
                max = arr[i];
            }
        }
        return max;
    }
}