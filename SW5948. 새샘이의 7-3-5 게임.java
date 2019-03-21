import java.util.Arrays;
import java.util.Scanner;

// SW5948. 새샘이의 7-3-5 게임
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = 0; // test case

		T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int[] numbers = new int[7];

			for (int i = 0; i < 7; i++) {
				numbers[i] = scan.nextInt();
			}

			int[] array = new int[35];
			int count = 0;

			for (int i = 0; i < 5; i++) {
				for (int j = i + 1; j < 6; j++) {
					for (int k = j + 1; k < 7; k++) {
						array[count++] = numbers[i] + numbers[j] + numbers[k];
					}
				}
			}

			Arrays.sort(array);

			int check = 0;
			int number = array[count - 1] + 10;
			for (int i = count - 1; i >= 0; i--) {
				if (number > array[i]) {
					check++;
					number = array[i];
					
					if (check == 5)
						break;
				}
			}
			
			System.out.println("#" + test_case + " " + number);
		}
	}

}
