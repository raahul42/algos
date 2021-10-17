package algos;

import java.util.Arrays;

// bit operations are faster than decimal ops
public class FastMath {

	public static void main(String[] args) {

		System.out.println(fastPower(3, 5));

		boolean[] bool = isPrime(20);
		for (int i=0;i<bool.length;i++) {
			System.out.println(i+" "+bool[i]);
		}
	}

	static int fastPower(int a, int b) {

		int res = 1;

		while (b > 0) {
			if ((b & 1) != 0) { // if its odd (when b becomes 1 too)
				res = res * a;
			}
			a = a * a;
			b = b >> 1; // gets halved
		}

		return res;
	}

	static int fastFactof(int num) {
		while (num > 1) {
			return num * fastFactof(num - 1);
		}
		return 1;
	}

	static boolean[] isPrime(int n) { // sieve of Eristosthenis
		boolean[] bool = new boolean[n + 1];
		Arrays.fill(bool, true);
		bool[0] = false;
		bool[1] = false;

		for (int i = 2; i * i <= n; i++) {
			for (int j = 2 * i; j <= n; j += i) {
				bool[j] = false;
			}
		}
		return bool;
	}

}