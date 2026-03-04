import java.io.*;
import java.util.*;

public class Main {
	static int V, E, K;
	static int[] dist;
	static List<int[]>[] graph; // 인접리스트
	static final int INF = 1_000_000_000;
	
	static void dijkstra(int start) {
		dist = new int[V+1];
		Arrays.fill(dist, INF); // 거리 초기화
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(
				(a,b) -> a[1] - b[1]
		);
		
		dist[start] = 0; //시작좌표 0 초기화
		pq.offer(new int[] {start, 0}); // 시작 좌표, 거리
		
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			int u = cur[0];
			int curDist= cur[1];
			
			if(curDist != dist[u]) continue;
			
			for(int[] next : graph[u]) {
				int v = next[0];
				int weight = next[1];
				
				if(curDist + weight < dist[v]) {
					dist[v] = curDist + weight;
					pq.offer(new int[] {v, curDist + weight});
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		// 시작 좌표
		K = Integer.parseInt((br.readLine().trim()));

		graph = new ArrayList[V+1];

		for(int i = 1; i <= V; i++) {
		    graph[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int dist = Integer.parseInt(st.nextToken());
			
			graph[start].add(new int[] {end, dist});
		}
		
		dijkstra(K);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i < dist.length; i++){
			if(dist[i] == INF) {
				sb.append("INF");
			}else {
				sb.append(dist[i]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
		
	}

}
