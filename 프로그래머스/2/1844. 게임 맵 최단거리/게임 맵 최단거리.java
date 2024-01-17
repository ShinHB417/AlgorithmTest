import java.util.*;

class Point {
    int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    static int[][] dis;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void BFS(int[][] maps, int x, int y) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        // 문제에서 칸을 세는 기준이 현재 위치 포함해서 하기 때문에 0시작이 아닌 1로 시작
        dis[x][y] = 1;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < maps.length && ny >= 0 && ny < maps[0].length && maps[nx][ny] == 1 ) {
                    maps[nx][ny] = 0;
                    q.add(new Point(nx, ny));
                    dis[nx][ny] = dis[cur.x][cur.y] + 1;
                }
            }
        }
    }

    public int solution(int[][] maps) {
        dis = new int[maps.length][maps[0].length];
        BFS(maps, 0, 0);

        if (dis[maps.length - 1][maps[0].length - 1] == 0) {
            return -1;
        } else {
            return dis[maps.length - 1][maps[0].length - 1];
        }
    }
}
