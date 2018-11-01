import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

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
					count = 1; // �ִ밪 ã������ �ʱ�ȭ
					Go(i, j); // ����
					score[i][j] = count;
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (max_count < score[i][j]) {
						max_count = score[i][j]; // �ִ� ��� �� ����
						min_number = room[i][j]; // �ּ� ���� �� ����

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
