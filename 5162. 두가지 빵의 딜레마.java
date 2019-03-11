import java.util.Scanner;

// 5162. µÎ°¡Áö »§ÀÇ µô·¹¸¶
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int A = scan.nextInt();
			int B = scan.nextInt();
			int C = scan.nextInt();

			int max = 0;

			if (A < B)
				max = C / A;
			else
				max = C / B;

			System.out.println("#" + test_case + " " + max);
		}

		scan.close();
	}
}