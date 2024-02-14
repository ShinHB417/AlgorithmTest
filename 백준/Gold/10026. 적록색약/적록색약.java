import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static char[][] board, boardRg;
    static int n, noRg, rg;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void BFS(boolean rg, int x, int y) {
        if (rg) {
            // 적록색약
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(x, y));
            char c = boardRg[x][y];
            boardRg[x][y] = 'X';
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                        if (c == 'B') {
                            if (boardRg[nx][ny] == 'B') {
                                boardRg[nx][ny] = 'X';
                                q.add(new Point(nx, ny));
                            }
                        } else {
                            if (boardRg[nx][ny] == 'R' || boardRg[nx][ny] == 'G') {
                                boardRg[nx][ny] = 'X';
                                q.add(new Point(nx, ny));
                            }
                        }
                    }
                }
            }
        } else {
            // 아닐 때
            Queue<Point> q = new LinkedList<>();
            q.add(new Point(x, y));
            char c = board[x][y];
            board[x][y] = 'X';
            while (!q.isEmpty()) {
                Point cur = q.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < n && c == board[nx][ny] && board[nx][ny] != 'X') {
                        board[nx][ny] = 'X';
                        q.add(new Point(nx, ny));
                    }
                }
            }
        }
    }

    public static void solution() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 'X') {
                    BFS(false, i, j);
                    noRg++;
                }
                if (boardRg[i][j] != 'X') {
                    BFS(true, i, j);
                    rg++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        board = new char[n][n];
        boardRg = new char[n][n];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                board[i][j] = str.charAt(j);
                boardRg[i][j] = str.charAt(j);
            }
        }
        solution();

        System.out.println(noRg + " " + rg);
    }
}
