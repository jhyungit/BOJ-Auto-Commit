import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static List<int[]> timeTable = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			timeTable.add(new int[] {start,end});
		}
		
		// 종료시간 기준 오름차순 정렬, 종료시간 같으면 시작시간 빠른 기준
		timeTable.sort((a,b) -> {
			if(a[1] == b[1]) return Integer.compare(a[0], b[0]);
			return Integer.compare(a[1], b[1]);
		});
		
		System.out.println(possibleCount());
	}
	
	static int possibleCount() {
		int ans = 0;
		int lastEnd = 0;
		
		for(int i = 0; i < timeTable.size(); i++) {
			int[] meeting = timeTable.get(i);
			int start = meeting[0];
			int end = meeting[1];
			
			if(start >= lastEnd) {
				ans++;
				lastEnd = end;
			}
		}
		return ans;
	}
}
