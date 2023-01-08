package algorithm;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
 * 
5
0 5 10 8 7 
5 0 5 3 6 
10 5 0 1 3 
8 3 1 0 1 
7 6 3 1 0

output==>10

7
0 32 31 0 0 60 51
32 0 21 0 0 0 0
31 21 0 0 46 0 25
0 0 0 0 34 18 0
0 0 46 34 0 40 51
60 0 0 18 40 0 0
51 0 25 0 51 0 0

output==>175
 * 
 * 
 */



public class MST2_PrimTest_PQ {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for(int i =0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }
        
        int res = 0;
        
        
        //신장트리에 포함여부 판단 배열
        boolean[] v = new boolean[N]; //그리디
        //다른 정점에서 자신으로의 최소비용을 저장하는 배열 공간 선언 및 최대값으로 초기화
        
        PriorityQueue<Data> pq = new PriorityQueue<>();
        pq.offer(new Data(0,0));
        // O(NlogN)
        Data cur = null;
        int cnt = 0;
        while(!pq.isEmpty()) { //모든 정점에서 연결해야 하는 최소갯수는 N-1
            //1.신장트리에 연결되지 않은 정점중에서 가장 유리한 정점을 선택 => pq poll logV
            cur = pq.poll();        
            if(v[cur.ver]) { //이미최소값으로 처리된 정점이 나중에 나온경우 배제필요함
                continue;
            }
            
            //2. 선택된 정점을 신장트리에 포함 시킴
            v[cur.ver] = true;
            // 그때 선택된 정점에 대한 최소 비용을 결과값에 저장
            res += cur.dis;
            cnt++;
            if(cnt == N) {
                break;
            }
            
            //3. 방금 선택된 정점 기준으로 신장트리에 포함되지 않은 정점으로 연결된
            //   간선비용을 따져봐서 최소비용을 업데이트 함
            //   (이 부분이 정렬하지 않고 최소값으로 찾기 만으로 다음 정점을 선택함)
            for(int i = 0; i < N; i++) {  //인접리스트로 변경
                //신장트리에 포함된 놈은 제외
                if(v[i]) {
                    continue;
                }
                
                 //연결되지 않은 정점은 무시(인접 행렬)
                if(map[cur.ver][i] == 0) { //인접리스트
                    continue;
                }
                //새로 연결된 비용들은 우선순위 큐에 삽입한다.
                pq.offer(new Data(i, map[cur.ver][i]));
            }
        }
        //MST값 출력
        System.out.println(res);
        
    }
    //pq
    static class Data implements Comparable<Data>{
        int ver;
        int dis;
        public Data(int ver, int dis) {
            super();
            this.ver = ver;
            this.dis = dis;
        }
        @Override
        public String toString() {
            return "Data [ver=" + ver + ", dis=" + dis + "]";
        }
        @Override
        public int compareTo(Data o) {
            // TODO Auto-generated method stub
            return Integer.compare(dis, o.dis);
        }
        
    }

}