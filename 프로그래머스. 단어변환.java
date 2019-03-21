import java.util.Scanner;

// 프로그래머스 : 단어 변환
public class Solution {
	static int[] check;
	static int answer;

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		String begin = "zzz";
		String target = "aaa";
		String[] words = new String[] { "zza", "zaa", "aaa", "zab"};

		System.out.println(solution(begin, target, words));

		scan.close();
	}

	public static int solution(String begin, String target, String[] words) {
		int flag = 0;

		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(target)) {
				flag = 1;
				break;
			} else {
				flag = 2;
			}
		}

		if (flag == 1) {
			answer = 999999;
			check = new int[words.length];
			getSolution(begin, target, words, 0, 0);
		} else {
			answer = 0;
		}

		return answer;
	}

	public static void getSolution(String word, String target, String[] words, int checkIndex, int count) {
		
		if (word.equals(target)) {
			if (count < answer)
				answer = count;

			return;
		} else {
			int index = 0;
			int wordLen = word.length();

			while (index < wordLen) {
				char a = 97;
				for (int i = 0; i < 26; i++) {
					String temp = word.substring(0, index) + (a++) + word.substring(index + 1);

					for (int j = 0; j < words.length; j++) {
						if (temp.equals(words[j]) && check[j] != 1) {
							check[j] = 1;
							getSolution(temp, target, words, j, count + 1);
							check[j] = 0;
						}
					}
				}
				index++;
			}
		}
	}

}