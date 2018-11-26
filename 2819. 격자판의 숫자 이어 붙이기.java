import java.util.Scanner;

// 2819. 격자판의 숫자 이어 붙이기
public class Solution {
	static int[][] map;
	static boolean[] check_sentence;
	static int count;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			map = new int[4][4];
			check_sentence = new boolean[10000000];
			count = 0;
			
			int max = 0;

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					map[i][j] = scan.nextInt();
				}
			}

			for (int i = 0; i < 4; i++) {
				for (int j = 0; j < 4; j++) {
					DFS(i, j, "");

					if (max <= count)
						max = count;
				}
			}

			System.out.println("#" + test_case + " " + max);

		}

	}

	public static void DFS(int i, int j, String sentence) {

		sentence = sentence + map[i][j];

		if (sentence.length() == 7) {
			if (!check_sentence[Integer.parseInt(sentence)]) {
				check_sentence[Integer.parseInt(sentence)] = true;
				count++;
			}
			return;

		} else {
			if (i - 1 >= 0)
				DFS(i - 1, j, sentence);
			if (j + 1 < 4)
				DFS(i, j + 1, sentence);
			if (i + 1 < 4)
				DFS(i + 1, j, sentence);
			if (j - 1 >= 0)
				DFS(i, j - 1, sentence);
		}
	}
}
