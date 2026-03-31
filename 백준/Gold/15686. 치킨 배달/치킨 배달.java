import java.io.*;
import java.util.*;

//1집, 2치킨집
public class Main {
	static int N, M;
	static int ans = Integer.MAX_VALUE;
	
	static List<int[]> chickenLoc = new ArrayList<>();
	static List<int[]> house = new ArrayList<>();
	static int[] selected;
	
	static void combi(int start, int depth) {
		if(depth == M) {
			int cityChickenDist = 0;
			
			for(int h = 0; h < house.size(); h++) {
				int hr = house.get(h)[0];
				int hc = house.get(h)[1];
				
				int dist = Integer.MAX_VALUE;
				
				for(int k = 0; k < M; k++) {
					int idx = selected[k];
                    int cr = chickenLoc.get(idx)[0];    // 치킨집의 r
                    int cc = chickenLoc.get(idx)[1];    // 치킨집의 c

                    dist = Math.min(dist, Math.abs(hr - cr) + Math.abs(hc - cc));
                }

                cityChickenDist += dist;

                // 가지치기
                if (cityChickenDist >= ans) return;
            }
			
			ans = Math.min(ans,cityChickenDist);
			return;
		}
		
		for(int i = start; i < chickenLoc.size(); i++) {
			int r = chickenLoc.get(i)[0];
			int c = chickenLoc.get(i)[1];
			
			selected[depth] = i;
			combi(i+1,depth+1);
		}
		
		
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// NxN, 치킨집 M개 선택 
		N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        for(int i = 0; i < N; i++) {
        	st = new StringTokenizer(br.readLine());
        	for(int j = 0; j < N; j++) {
            	int num = Integer.parseInt(st.nextToken());
            	
            	if(num == 1) house.add(new int[] {i+1,j+1}); // 집 좌표 저장
            	else if(num == 2) chickenLoc.add(new int[] {i+1,j+1}); // 치킨집 좌표 저장
            }	
        }
        
        selected = new int[M];
        
        combi(0, 0); // start, depth
        
        System.out.println(ans);
	}
}
