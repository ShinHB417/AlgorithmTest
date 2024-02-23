import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] unf,truth;
    static ArrayList<ArrayList<Integer>> party;

    public static int Find(int v){
        if(v == unf[v]) return v;
        else return unf[v] = Find(unf[v]);
    }
    public static void Union(int a, int b){
        int fa = Find(a);
        int fb = Find(b);

        if(fa != fb) unf[fa] = fb;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); //사람 수
        m = Integer.parseInt(st.nextToken()); // 파티 수
        unf = new int[n+1];
        truth = new int[n+1];
        for(int i = 1; i <=n; i++){
            unf[i] = i;
        }

        st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken()); // 진실을 아는사람의 수

        if(a== 0){
            System.out.println(m);
            return;
        }
        for(int i = 0; i < a; i++){
            int b = Integer.parseInt(st.nextToken());
            truth[b] = 1;
        }
        party = new ArrayList<>();
        for(int i = 0; i < m; i++){
            party.add(new ArrayList<>());
        }
        for(int i = 0; i < m; i ++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for(int j = 0; j < num; j++){
                party.get(i).add(Integer.parseInt(st.nextToken()));

                if(j != 0){
                    int pre = party.get(i).get(j-1);
                    int now = party.get(i).get(j);

                    Union(pre,now);
                }
            }
        }
        boolean[] visited = new boolean[n+1];
        for(int i = 1; i <=n; i++){
            if(truth[i] == 1 && visited[i] == false){
                int root = Find(i);

                for(int j = 1; j <=n; j++){
                    if(Find(j) == root){
                        truth[j] = 1;
                        visited[j] = true;
                    }
                }
            }
        }
        //파티에 진실을 아는 사람이 있는지 확인
        boolean[] goParty = new boolean[m];
        for(int i = 0; i<m; i++)
            goParty[i] = true;

        for(int i = 0; i<m; i++){
            for(int j = 1; j<=n; j++){
                if(truth[j] == 1){
                    if(party.get(i).contains(j))
                        goParty[i] = false;
                }
            }
        }

        int sum = 0;
        for(int i = 0; i<m; i++)
            if(goParty[i])
                sum++;

        System.out.println(sum);

    }

}