import java.io.BufferedReader;
import java.io.InputStreamReader;


import java.util.*;

public class Main {
	static int N, M;
	static int[] use;
	static StringBuilder sb = new StringBuilder();	
	
	public static void main(String args[]) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		use = new int[M];
		dfs(0, 1);
		System.out.println(sb);
		
		
	}
	
	static void dfs(int depth, int start) {
		if(depth == M) {
			for(int i=0; i<M;i++) {
				sb.append(use[i]).append(i == M-1? "\n":" ");
			}
			return;
		}
		
		for(int i=start; i<=N; i++) {
			use[depth] = i;
			dfs(depth+1, i+1);
		}
	}

}