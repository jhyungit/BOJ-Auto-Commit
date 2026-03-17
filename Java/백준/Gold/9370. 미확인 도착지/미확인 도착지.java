import java.io.*;
import java.util.*;

public class Main {
	
	static int T;
	static int n, m, t;
	static int s, g, h;
	static int[] dist;
	
	static List<int[]>[] graph;
	static StringBuilder sb = new StringBuilder();
	
	static final int INF = 1_000_000_000;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine().trim());
		
		for(int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// n(교차로), m(도로 개수), t(목적지 후보 개수)
			n = Integer.parseInt(st.nextToken());
			m = Integer.parseInt(st.nextToken());
			t = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			// s(출발지), g-h사이 도로 지나감
			s = Integer.parseInt(st.nextToken());
			g = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			graph = new ArrayList[n+1];
			for(int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}
			
			// 양방향 도로 입력
			for(int i = 0; i < m; i++) {
				st = new StringTokenizer(br.readLine());
				// a----b, 길이 d
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int d = Integer.parseInt(st.nextToken());
				
				graph[a].add(new int[] {b,d});
				graph[b].add(new int[] {a,d});
			}
			
			int[] destCandi = new int[t];
			// t개의 목적지 후보
			for(int i = 0; i < t; i++) {
				int x = Integer.parseInt(br.readLine().trim());
				destCandi[i] = x;
			}
			
			int[] distS = dijkstra(s); // 출발 -> 모든 최단거리
			int[] distG = dijkstra(g); // g -> 모든 최단거리
			int[] distH = dijkstra(h); // h -> 모든 최단거리			
			
			List<Integer> temp = new ArrayList<>();
			for(int dest : destCandi) {
				int ans = 0;
				// s -> g -> h -> d
				int sghd = distS[g] + distG[h] + distH[dest];
				// s -> h -> g -> d
				int shgd = distS[h] + distH[g] + distG[dest];
				
				// 둘 중 하나가 최단거리면
				if(sghd == distS[dest] || shgd == distS[dest]) temp.add(dest);
			}			
			Collections.sort(temp);
			
			for(Integer num : temp) {
				sb.append(num).append(" ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static int[] dijkstra(int start) {

		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1]-b[1]);
		dist = new int[n+1];
		Arrays.fill(dist, INF);
		
		pq.offer(new int[] {start,0});
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int node = cur[0];
			int cost = cur[1];
			
			if(cost > dist[node]) continue;
			
			for(int[] next: graph[node]) {
				int nextNode = next[0];
				int nextCost = next[1];
				
				if(dist[nextNode] > cost+nextCost) {
					dist[nextNode] = cost+nextCost;
					pq.offer(new int[] {nextNode, dist[nextNode]});
				}
			}
		}
		
		return dist;
	}

}
