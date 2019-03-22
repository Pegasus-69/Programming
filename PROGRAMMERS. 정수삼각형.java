import java.util.Scanner;

// 프로그래머스 : 정수 삼각형
public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

//		int[][] triangle = new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int[][] triangle = new int[][] { { 10 }, { 9, 8 }, { 7, 6, 5 }, { 4, 3, 2, 1 }};

		System.out.println(solution(triangle));

		scan.close();
	}

	public static int solution(int[][] triangle) {
		int yLen = triangle.length;
		int xLen = 0;

		for (int i = yLen - 1; i > 0; i--) {
			xLen = triangle[i].length;

			for (int j = 0; j < xLen - 1; j++) {
				if (triangle[i][j] <= triangle[i][j + 1]) {
					triangle[i - 1][j] = triangle[i][j + 1] + triangle[i - 1][j];
				} else {
					triangle[i - 1][j] = triangle[i][j] + triangle[i - 1][j];
				}
			}
		}

		int answer = triangle[0][0];

		return answer;
	}

}