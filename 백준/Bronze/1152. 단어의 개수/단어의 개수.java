import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        String[] arr = str.split(" ");

        if(str.charAt(0) == ' '){
            if(arr.length == 0){
                System.out.println(arr.length);
            }else{
                System.out.println(arr.length-1);
            }

        }else{
            System.out.println(arr.length);
        }





    }
}