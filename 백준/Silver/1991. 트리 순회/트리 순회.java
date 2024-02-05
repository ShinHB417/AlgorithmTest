import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    char data;
    Node lt,rt;

    public Node(char data, Node lt, Node rt){
        this.data = data;
        this.lt = lt;
        this.rt = rt;
    }
}

public class Main {

    public static void insertNode(Node temp, char root, char left, char right){
        if(temp.data == root){
            temp.lt = (left =='.' ? null : new Node(left,null,null));
            temp.rt = (right == '.' ? null : new Node(right,null,null));
        }else{
            if(temp.lt != null) insertNode(temp.lt, root, left,right);
            if(temp.rt != null) insertNode(temp.rt, root, left,right);
        }
    }

    private static void postOrder(Node n) {
        if(n==null)	return;
        postOrder(n.lt);
        postOrder(n.rt);
        System.out.print(n.data);
    }

    private static void inOrder(Node n) {
        if(n==null)	return;
        inOrder(n.lt);
        System.out.print(n.data);
        inOrder(n.rt);
    }

    private static void preOrder(Node n) {
        if(n==null)	return;
        System.out.print(n.data);
        preOrder(n.lt);
        preOrder(n.rt);

    }


    static Node head = new Node('A',null,null);

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        scan.nextLine();
        for(int i = 0; i <n; i++){
            String[] str = scan.nextLine().split(" ");
            char root = str[0].charAt(0);
            char left = str[1].charAt(0);
            char right = str[2].charAt(0);

            insertNode(head,root ,left,right);
        }
        preOrder(head);
        System.out.println();
        inOrder(head);
        System.out.println();
        postOrder(head);
    }


}




