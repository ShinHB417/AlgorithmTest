import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        String str = scan.nextLine();

        str = str.toUpperCase();

        int max = -1;
        char result = '?';
        int[] count = new int[26];

        for(int i = 0; i<str.length(); i++){
            count[str.charAt(i) - 65]++;
            if(max < count[str.charAt(i) - 65]){
                max = count[str.charAt(i)-65];
                result = str.charAt(i);
            }else if(max == count[str.charAt(i) - 65]){
                result = '?';
            }
        }
        System.out.println(result);








    }
}