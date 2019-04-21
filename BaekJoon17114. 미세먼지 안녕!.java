import java.util.*;

// 백준 17114. 미세먼지 안녕!
public class Solution {
	static int R;
	static int C;
	static int T;
	static int[][] map;
	static int[][] copy;

	static int xPos;
	static int yPos;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		R = scan.nextInt();
		C = scan.nextInt();
		T = scan.nextInt();

		map = new int[R][C];
		copy = new int[R][C];

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				map[i][j] = scan.nextInt();

				if (map[i][j] == -1) {
					copy[i][j] = -1;
					xPos = j;
					yPos = i;
				}
			}
		}

		for (int time = 0; time < T; time++) {
			ChinaDust();
			Clean();
		}
		System.out.println(Counts());
		
		scan.close();
	}

	public static void ChinaDust() {
		ArrayCopy(copy, map);
		int[] dy = new int[] { -1, 0, 1, 0 };
		int[] dx = new int[] { 0, 1, 0, -1 };
		int ny = 0;
		int nx = 0;
		int value = 0;
		int count = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1 && map[i][j] != 0) {
					value = map[i][j] / 5;
					count = 0;

					for (int k = 0; k < 4; k++) {
						ny = i + dy[k];
						nx = j + dx[k];

						if (check(ny, nx)) {
							count++;
							copy[ny][nx] += value;
						}
					}
					copy[i][j] = (copy[i][j] - (value * count));
				}

			}
		}
		ArrayCopy(map, copy);
	}

	public static void Clean() {
		// 공기청정기 위에 방향
		int i = yPos - 1;
		int j = xPos;
		int flag = -1;

		int N = yPos - 2;
		int M = C - 1;

		while (true) {
			for (int a = 1; a <= N; a++) {
				i = i + flag;
				if (flag == 1) {
					map[i][j] = map[i + 1][j];
				} else {
					map[i][j] = map[i - 1][j];
				}
			}

			if (flag == 1) {
				i++;
				j++;
			} else {
				i--;
				j--;
			}

			N = N + 1;
			flag = flag * -1;

			for (int a = 1; a <= M; a++) {
				j = j + flag;
				if (flag == 1) {
					map[i][j] = map[i][j + 1];
				} else {
					map[i][j] = map[i][j - 1];
				}
			}

			M = M - 1;
			if (flag == 1) {
				i--;
				j++;
			} else {
				j--;
				map[i][j] = 0;
				if (map[i][j - 1] == -1)
					break;
			}
		}
		// 공기청정기 아래 방향
		i = yPos;
		j = xPos;
		flag = 1;

		N = (R - 1) - (yPos + 1);
		M = C - 1;

		while (true) {
			for (int a = 1; a <= N; a++) {
				i = i + flag;
				if (flag == 1) {
					map[i][j] = map[i + 1][j];
				} else {
					map[i][j] = map[i - 1][j];
				}

			}

			if (flag == 1) {
				i++;
				j--;
			} else {
				i--;
				j++;
			}

			N = N + 1;

			for (int a = 1; a <= M; a++) {
				j = j + flag;
				if (flag == 1) {
					map[i][j] = map[i][j + 1];
				} else {
					map[i][j] = map[i][j - 1];
				}

			}

			M = M - 1;
			flag = flag * -1;
			if (flag == 1) {
				j--;

				map[i][j] = 0;
				if (map[i][j - 1] == -1)
					break;
			} else {
				i++;
				j++;
			}
		}
	}

	public static boolean check(int ny, int nx) {
		if ((0 <= ny && ny < R) && (0 <= nx && nx < C)) {
			if (map[ny][nx] != -1)
				return true;
			else
				return false;
		} else {
			return false;
		}
	}

	public static void ArrayCopy(int[][] a, int[][] b) {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				a[i][j] = b[i][j];
			}
		}
	}

	public static int Counts() {
		int sum = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] != -1)
					sum = sum + map[i][j];
			}
		}
		return sum;
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (map[i][j] == -1)
					System.out.print("#" + " ");
				else
					System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
}