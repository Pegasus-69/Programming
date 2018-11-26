import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

//4406. 모음이 보이지 않는 사람
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = 0; // test case
		
		T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			String sentence = scan.next();
			
			sentence = sentence.replace("a", " ");
			sentence = sentence.replace("e", " ");
			sentence = sentence.replace("i", " ");
			sentence = sentence.replace("o", " ");
			sentence = sentence.replace("u", " ");
			sentence = sentence.replace(" ", "");
			
			System.out.println("#" + test_case + " " + sentence);
		}
	}
}
