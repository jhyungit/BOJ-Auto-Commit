import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] picked, parent;
	
	static double ans;
	
	static List<double[]> stars = new ArrayList<>();
	static List<Distances> distances = new ArrayList<>();
	
	static class Distances{
		int a, b;
		double dist;
		
		Distances(int a, int b, double dist){
			this.a = a;
			this.b = b;
			this.dist = dist;
		}
	}
	
	static void combi(int start, int depth) {
		if(depth == 2) {
			int s = picked[0]; // 출발 별
			int e = picked[1]; // 다음 별
			
			// 출발 별 sX,sY
			double sX = stars.get(s)[0];
			double sY = stars.get(s)[1];
			
			// 다음 별 sX,sY
			double eX = stars.get(e)[0];
			double eY = stars.get(e)[1];
			
			double lenX = Math.abs(sX-eX);
			double lenY = Math.abs(sY-eY);
			
			// 출발 별 - 다음 별 거리 계산
			double dist = Math.hypot(lenX, lenY);
			
			distances.add(new Distances(s,e,dist));
			return;
		}
		
		for(int i = start; i <= N; i++) {
			picked[depth] = i;
			combi(i+1, depth+1);
		}
	}
	
	static int findParent(int x) {
		if(parent[x] == x) return x;
		return parent[x] = findParent(parent[x]);
	}
	
	static void unionParent(int a, int b) {
		int x = findParent(a);
		int y = findParent(b);
		
		if(x<y) parent[y] = x;
		else parent[x] = y;
	}
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine().trim());
		
		parent = new int[N+1];
		
		stars.add(new double[] {}); // 별 0은 없음 
		// 별 star의 좌표 x,y
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(st.nextToken());
			double y = Double.parseDouble(st.nextToken());
			parent[i+1] = i+1;
			
			stars.add(new double[] {x,y});
		}
		
		
		picked = new int[2];
		// 두 별을 뽑는 모든 조합 구하기
		combi(1, 0); // start, depth
		
		// 거리 기준 오름차순 정렬
		distances.sort((a,b) -> Double.compare(a.dist, b.dist));
		
		for(Distances info : distances) {
			int a = info.a;
			int b = info.b;
			double dist = info.dist;

			if(findParent(a) != findParent(b)) { // 경로 압축
				unionParent(a,b);
			}else { // cycle 발생
				continue;
			}
			ans += dist;
		}
		
		System.out.println(ans);
	}

}