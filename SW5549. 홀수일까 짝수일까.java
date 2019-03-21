import java.util.Scanner;

// SW5549. 홀수일까 짝수일까
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt(); // test_case 수

		for (int test_case = 1; test_case <= T; test_case++) {
			String N = scan.next();
			String answer = null;
			
			int number = N.charAt(N.length() - 1) - '0';
			
			if (number % 2 == 0)
				answer = "Even";
			else
				answer = "Odd";
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
