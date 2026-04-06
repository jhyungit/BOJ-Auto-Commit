import java.io.*;
import java.util.*;

public class Main {
	static int[] fibo;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine().trim());
		
		fibo = new int[Math.max(3, n+1)];
		fibo[0] = 0;
		fibo[1] = 1;
		fibo[2] = 2;
		
		for(int i = 3; i <= n; i++) {
			fibo[i] = (fibo[i-1] + fibo[i-2]) % 10007;;
		}
		System.out.println(fibo[n] % 10007);
	}
}
