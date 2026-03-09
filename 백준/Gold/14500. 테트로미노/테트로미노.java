import java.io.*;
import java.util.*;

public class Main {
	static int R, C, ans;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {0,0,-1,1};
	static int[] dc = {-1,1,0,0};
	
	public static void main(String args[]) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		visited = new boolean[R][C];
		
		for(int r = 0; r < R; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < C; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	
		// 4가지 연결 가능 경우 탐색
		for(int r = 0; r < R; r++) {
			for (int c = 0; c < C; c++) {
				visited[r][c] = true;
				dfs(r, c, 1, map[r][c]);
				visited[r][c] = false;
				
				checkT(r, c);
			}
		}
		System.out.println(ans);
	}
	
	static void dfs(int r, int c, int depth, int sum){
		if(depth == 4) {
			ans = Math.max(ans, sum);
			return;
		}
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위 밖
			
			if(visited[nr][nc]) continue; //이미 방문
			
			visited[nr][nc] = true;
			dfs(nr, nc, depth+1, sum + map[nr][nc]);
			visited[nr][nc] = false;
		}
	}
	
	static void checkT(int r, int c) { // ㅏ ㅜ ㅓ ㅗ 체크
		// 가운데 기준 - 상하좌우 중 택 3
		int use = 0;
		int sum = map[r][c];
		int min = Integer.MAX_VALUE; // +를 ㅏㅜㅓㅗ로 만들 때, 가장 작은 거 선택해서 빼기 위한 min
		
		for(int k = 0; k < 4; k++) {
			int nr = r + dr[k];
			int nc = c + dc[k];
			
			if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue; // 범위 밖
			
			use++;
			sum += map[nr][nc];
			min = Math.min(min, map[nr][nc]);
		}
		
		if(use < 3) return;
		if(use == 3) ans = Math.max(ans, sum);
		else ans = Math.max(ans, sum - min);
	}
	
}

