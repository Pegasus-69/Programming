import java.util.Scanner;

//5549. È¦¼öÀÏ±î Â¦¼öÀÏ±î
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt(); // test_case ¼ö

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
