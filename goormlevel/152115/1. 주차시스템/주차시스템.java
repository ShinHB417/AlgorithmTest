import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 0 자동차 없음
 * 1 자동차 있음
 * 2 없지만 장애인 전용
 */

class Point {
    int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int row, col;
    static int[][] board;
    static boolean[][] visited; // 방문 여부를 저장하는 배열

    static ArrayList<Integer> list = new ArrayList<>();

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void solution() {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if ((board[i][j] == 0 || board[i][j] == 2) && !visited[i][j]) {
                    int score = BFS(i, j); // 각 구역의 점수 계산
                    list.add(score);
                }
            }
        }
    }

    public static int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        int score = 0;

        if (board[x][y] == 0) {
            score++;
        } else if (board[x][y] == 2) {
            score -= 2;
        }

        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx >= 0 && nx < row && ny >= 0 && ny < col && !visited[nx][ny] && (board[nx][ny] == 0 || board[nx][ny] == 2)) {
                    if (board[nx][ny] == 0) {
                        score++;
                    } else if (board[nx][ny] == 2) {
                        score -= 2;
                    }
                    visited[nx][ny] = true;
                    q.add(new Point(nx, ny));
                }
            }
        }
        return score; // 현재 구역의 점수를 반환
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        row = Integer.parseInt(st.nextToken());
        col = Integer.parseInt(st.nextToken());
        board = new int[row][col];
        visited = new boolean[row][col]; // 방문 배열 초기화

        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solution();
        int answer = 0; // 양수인 구역 점수가 없는 경우 0을 출력하기 위해 초기값을 0으로 설정
        for (int i : list) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
