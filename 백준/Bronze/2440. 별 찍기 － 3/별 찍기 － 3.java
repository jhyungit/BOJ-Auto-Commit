import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<n; i++) {
			StringBuilder temp = new StringBuilder();
			for(int j=0; j<n-i; j++) {
				temp.append("*");
			}
			System.out.print(temp);
			System.out.println();
		}
	}

}
