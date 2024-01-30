import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine(); // 버퍼 비우기

        TreeSet<String> set = new TreeSet<>(new CustomComparator());

        for (int i = 0; i < n; i++) {
            String str = scan.nextLine();
            set.add(str);
        }

        for (String s : set) {
            System.out.println(s);
        }
    }
}

class CustomComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        // 길이로 비교
        int lengthComparison = Integer.compare(s1.length(), s2.length());

        // 길이가 같으면 사전순 오름차순으로 비교
        if (lengthComparison == 0) {
            return s1.compareTo(s2);
        }

        return lengthComparison;
    }
}
