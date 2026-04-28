import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int nextInt() throws Exception{
		while(st == null || !st.hasMoreTokens()) {
			st = new StringTokenizer(br.readLine());
		}
		
		return Integer.parseInt(st.nextToken());
	}

	public static void main(String[] args) throws Exception {
		int n = nextInt();
		StringBuilder sb = new StringBuilder();
		
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) sb.append('*');
            sb.append('\n');
        }
		System.out.println(sb);
	}
}