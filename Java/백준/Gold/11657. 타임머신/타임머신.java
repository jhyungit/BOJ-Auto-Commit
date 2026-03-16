// 음수 가중치이므로 벨만 포드 
import java.io.*;
import java.util.*;

public class Main {
	
	static class Edge{
		int u, v, w;
		
		Edge(int u, int v, int w){
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}
	
	static int N, M;
	static final long INF = Long.MAX_VALUE / 4;
	static List<Edge> edges = new ArrayList<>();

	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 단 방향
		// 도시개수 N, 버스 노선 개수 M
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			edges.add(new Edge(u, v, w));
		}
		
		long[] dist = bellmanFord(1);
		
		StringBuilder sb = new StringBuilder();
		
		if(dist == null) {
			sb.append(-1);
		}else {
			for(int i = 2; i <= N; i++) {
				if(dist[i] == INF) sb.append(-1).append("\n");
				else sb.append(dist[i]).append("\n");
			}	
		}
		System.out.println(sb);
	}
	
	static long[] bellmanFord(int start) {
		long[] dist = new long[N+1];
		Arrays.fill(dist, INF);
		
		dist[start] = 0;
		
		// N-1번 완화
		for(int i = 1; i <= N-1; i++) {
			for(Edge e : edges) {
				if(dist[e.u] != INF && dist[e.v] > dist[e.u] + e.w) {
					dist[e.v] = dist[e.u] + e.w;
				}
			}
		}
		
		// 음수 사이클 확인
		for(Edge e : edges) {
			if(dist[e.u] != INF && dist[e.v] > dist[e.u] + e.w) {
				return null;
			}
		}
		
		return dist;
	}
}