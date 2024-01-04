import java.io.*;
import java.util.*;

public class Main {
    static boolean[] visited;
    static int n, m;
    static int[] pm;

    public void DFS(int l) {
        if (l == m) {
            for (int x : pm) System.out.print(x + " ");
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    pm[l] = i + 1;
                    DFS(l + 1);
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        Main T = new Main();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n];
        pm = new int[m];
        T.DFS(0);
    }
}
