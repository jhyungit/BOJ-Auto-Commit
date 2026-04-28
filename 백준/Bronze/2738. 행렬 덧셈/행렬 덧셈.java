
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] a = new int[n][m];
		int[][] b = new int[n][m];
		
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<m;j++) {
			a[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i =0; i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0; j<m;j++) {
			b[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[][] ans = new int[n][m];
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<m; j++) {
				ans[i][j] = a[i][j] + b[i][j];
			}
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0;j<m; j++) {
				System.out.print(ans[i][j]+" ");
			}
			System.out.println();
		}
	}

}
