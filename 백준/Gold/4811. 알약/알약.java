import java.io.*;
import java.util.*;

public class Main {
	static long[][] dp = new long[31][31];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = -1;
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			n = Integer.parseInt(br.readLine().trim());
			if(n == 0) break;
			long ans = solution(n, 0);
			sb.append(ans).append('\n');
		}
		
		System.out.println(sb);
		
	}
	
	static long solution(int w, int h) {
		// 기저 조건
		if(w == 0 && h == 0) {
			return 1;
		}
		
		// 이미 계산한 값이면
		if(dp[w][h] != 0) return dp[w][h];
		
		//점화식 적용
		if(w > 0) dp[w][h] += solution(w-1, h+1);
		if(h > 0) dp[w][h] += solution(w, h-1);
		
		return dp[w][h];
	}
}
