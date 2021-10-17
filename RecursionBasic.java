package algos;

// RECURSIVE LEAP OF FAITH FTW
public class RecursionBasic {

	public static void main(String[] args) {

		System.out.println(factorialOf(6));

		System.out.println(gcdOf(60, 24));

		System.out.println(pathsAcross(4, 4));

		System.out.println(survivorOf(5, 3));

	}

	static int factorialOf(int num) {
		if (num == 0) {
			return 1;
		}
		return num * factorialOf(num - 1);
	}

	static int gcdOf(int a, int b) {
		if (b == 0) {
			return a;
		}
		return gcdOf(b, a % b); // from math theorems
	}

	static int pathsAcross(int m, int n) { // path from start to end in a matrix of size m*n
		if (m == 1 || n == 1) {
			return 1;
		}
		return (pathsAcross(m - 1, n) + pathsAcross(m, n - 1));
	}

	static int survivorOf(int m, int n) { // Joseph's problem --> m ppl in a circle killing nth person each time
		if (m == 0) {
			return 0;
		}
		return (survivorOf(m - 1, n) + n) % m; // one person dies and gun goes to the next guy (%m to go in circle)
	}

}
