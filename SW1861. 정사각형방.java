import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// SW1861. 정사각형방
public class Solution {
	static int N = 0;
	static int count;
	static int[][] room;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int T = 0; // test case

		int[][] score;

		T = scan.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			N = scan.nextInt();
			int max_count = 0;
			int min_number = 0;

			room = new int[N][N];
			score = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					room[i][j] = scan.nextInt();

					if (min_number <= room[i][j])
						min_number = room[i][j];
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					count = 1; // 최대값 찾기위해 초기화
					Go(i, j); // ㄱㄱ
					score[i][j] = count;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max_count < score[i][j]) {
						max_count = score[i][j]; // 최대 경로 값 변경
						min_number = room[i][j]; // 최소 숫자 값 변경

					}
					if (max_count == score[i][j]) {
						if (min_number >= room[i][j]) {
							min_number = room[i][j];
						}
					}
				}
			}

			System.out.println("#" + test_case + " " + min_number + " " + max_count);
		}
	}

	static public void Go(int i, int j) {
		if (i - 1 >= 0 && (room[i][j] + 1 == room[i - 1][j])) {
			count++;
			Go(i - 1, j);
		}

		if (j + 1 <= N - 1 && (room[i][j] + 1 == room[i][j + 1])) {
			count++;
			Go(i, j + 1);
		}

		if (i + 1 <= N - 1 && (room[i][j] + 1 == room[i + 1][j])) {
			count++;
			Go(i + 1, j);
		}

		if (j - 1 >= 0 && (room[i][j] + 1 == room[i][j - 1])) {
			count++;
			Go(i, j - 1);
		}
	}
}
