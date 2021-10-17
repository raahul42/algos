package algos;

import java.util.HashSet;
import java.util.Set;

public class RecursionStrings {

	static Set<String> Powerset = new HashSet<>();
	static Set<String> set = new HashSet<>();

	public static void main(String[] args) {

		String str = "aba";

		System.out.println("Palindrome : " + isPalindrome(str, 0, str.length() - 1));

		PowerSetOf(str, "", 0, str.length());
		System.out.println("Power-set : " + Powerset);

		permutesOf(str, 0, str.length() - 1);
		System.out.println("Permutations : " + set);

	}

	static boolean isPalindrome(String s, int l, int r) {
		if (l >= r) {
			return true;
		}
		if (s.charAt(l) != s.charAt(r)) {
			return false;
		}
		return isPalindrome(s, l + 1, r - 1);
	}

	static void PowerSetOf(String s, String cur, int l, int r) {
		if (l == r) {
			Powerset.add(cur);
			return;
		}
		PowerSetOf(s, cur + s.charAt(l), l + 1, r); // adding the next char
		PowerSetOf(s, cur, l + 1, r); // not adding the next char
	}

	static void permutesOf(String s, int l, int r) {

		for (int i = l; i <= r; i++) {
			s = swap(s, l, i);
			permutesOf(s, l + 1, r);
			s = swap(s, l, i);
		}
		if (l == r) {
			set.add(s);
			return;
		}

	}

	static String swap(String s, int l, int r) {

		StringBuffer buf = new StringBuffer(s);
		char temp = buf.charAt(l);
		buf.replace(l, l + 1, Character.toString(buf.charAt(r)));
		buf.replace(r, r + 1, Character.toString(temp));

		return buf.toString();
	}
}
