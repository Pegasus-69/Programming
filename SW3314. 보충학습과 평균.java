import java.util.Scanner;

// SW3314. 보충학습과 평균
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = 0; // test case

		T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int sum = 0;
			int[] array = new int[5];

			
			for (int i = 0; i < 5; i++) {
				array[i] = scan.nextInt();
				
				if (array[i] < 40)
					array[i] = 40;
				
				sum = sum + array[i];
			}
			
			System.out.println("#" + test_case + " " + (sum / 5));
		}
	}

}
