import java.util.*;
import java.io.*;

public class Main {
	static int[] ledState;
	static List<Integer> boys = new ArrayList<>();
	static List<Integer> girls = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		//---------솔루션 코드를 작성하세요.
//		1 켜져있음, 0 꺼져있음
//		n : LED개수
//		1~n까지 나눠줌
//		남학생: 배수들의 상태 바꿈 3, 6, 9
//		여학생: 자기 양 옆 최대 대칭 반전(나 포함)
		
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 
		 // LED 개수 입력
		 int n = Integer.parseInt(br.readLine().trim());
		 
		 // LED 상태
		 ledState = new int[n]; // 초기화 인덱스 편하게 하려고 n+1만큼
		 StringTokenizer st = new StringTokenizer(br.readLine());
		 for(int i = 0; i < n; i++) {
			 int state = Integer.parseInt(st.nextToken());
			 ledState[i] = state;
		 }
		 
		 // 학생수
		 int studentNum = Integer.parseInt(br.readLine().trim());
		 
		 // 학생들의 성별(1남자, 2여자), 받은 LED 위치(1~n)
		 for(int i = 0; i < studentNum; i++) {
			 st = new StringTokenizer(br.readLine());
			 int gender = Integer.parseInt(st.nextToken());
			 int loc = Integer.parseInt(st.nextToken());
			 
			 if (gender == 1) { // 남학생: 배수 토글
	                for (int pos = loc; pos <= n; pos += loc) {
	                    ledState[pos - 1] ^= 1;
	                }
	            }
			 else { // 여학생: 중심부터 대칭 확장
                int left = loc - 1;
                int right = loc - 1;

                // expand while symmetric
                while (left >= 0 && right < n && ledState[left] == ledState[right]) {
                    left--;
                    right++;
                }

                // (left+1) ~ (right-1)
                for (int j = left + 1; j <= right - 1; j++) {
                    ledState[j] ^= 1;
                }
            }
		 }
		 
		 StringBuilder sb = new StringBuilder();

		 for(int i=0; i<ledState.length;i++) {
			sb.append(ledState[i]).append(' ');	 
			if((i+1)%20==0)sb.append('\n');
		 }
		 System.out.println(sb.toString().trim());
	}

}