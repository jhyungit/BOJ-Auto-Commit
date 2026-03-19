// 태상이의 훈련소 생활
//https://www.acmicpc.net/problem/19951

import java.io.*;
import java.util.*;


public class Main{
	static int N, M; // 연병장 크기 N, 조교 수 M
	
	static int[] H;
	static int[] arr;
	public static void main(String[] args)  throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		H = new int[N+1];
		arr = new int[N+2];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			H[i] = Integer.parseInt(st.nextToken());
		}
		
//		a~b칸 높이 k만큼
//		a, b, k
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			calc(a, b, k);
			
		}
		
		// 누적합
		for(int i = 2; i < arr.length; i++) {
			arr[i] += arr[i-1];
		}

		for(int i = 1; i <= N; i++) {
			H[i] += arr[i];
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			sb.append(H[i]).append(' ');
		}
		System.out.println(sb);
	}
	
	static void calc(int a, int b, int k) {
		arr[a] += k;
		arr[b+1] += -k;
	}

}