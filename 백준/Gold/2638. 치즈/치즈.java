import java.io.*;
import java.util.*;

public class Main {
	static int R,C, time, cheeseNum;
	
	static int[] dr = {0,0,1,-1};
	static int[] dc = {1,-1,0,0};
	
	
	static int[][] map;
	static int[][] cheese;
	
	static void bfs(int r, int c) {
		boolean[][] visited = new boolean[R][C];
		cheese = new int[R][C];
		
		Deque<int[]> dq = new ArrayDeque<>();
		dq.offer(new int[] {r,c});
		visited[r][c] = true;
		
		while(!dq.isEmpty()) {
			int[] cur = dq.poll();
			int rr = cur[0];
			int cc = cur[1];
			
			for(int k = 0; k < 4; k++) {
				int nr = rr + dr[k];
				int nc = cc + dc[k];
				
				if(nr < 0 || nr >= R || nc < 0 || nc >= C) continue;
				if(visited[nr][nc]) continue;				
				if(map[nr][nc] == 1) {
					cheese[nr][nc]++;
					continue;
				}
				dq.offer(new int[] {nr,nc});
				visited[nr][nc] = true;
			}
		}
		
	}
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // n x m
        
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        
        map = new int[R][C];
        for(int r = 0; r < R; r++) {
        	st = new StringTokenizer(br.readLine());
        	for(int c = 0; c < C; c++) {
            	map[r][c] = Integer.parseInt(st.nextToken());
            	if(map[r][c] == 1) cheeseNum++;
            }	
        }
        
        
        while(cheeseNum != 0) {
        	bfs(0,0);
        	
        	for(int r = 0; r < R; r++) {
            	for(int c = 0; c < C; c++) {
            		if(cheese[r][c] >= 2) {
	        			map[r][c] = 0;
	        			cheese[r][c] = 0;
	        			cheeseNum--;
            		}
            	}
        	}
        	time++;
        }
        
        System.out.println(time);
    }
}