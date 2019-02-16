import java.util.ArrayList;
import java.util.Scanner;

public class Solution2 {

	public static long startTime;

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);

		System.out.println("n = ");

		int n = scan.nextInt();

		System.out.println("k = ");

		int k = scan.nextInt();


		scan.close();

		ArrayList<Integer> M = new ArrayList<Integer>();


		startTime = System.nanoTime();
		// startTime will be set before computing the k multitudes


		for(int i = 1 ; i <= n ; ++i) {

			if( i % (k + 1) != 0 || i == k + 1 ) {
				// Only numbers not divisible with k + 1 (except k + 1)
				// will be added to M
				M.add(i);
			}
		}

		FindPrimes2[] findPrimes = new FindPrimes2[k + 1];


		for(int j = 1 ; j <= k ; ++j) {
			// There are k threads and multitudes Mj

			ArrayList<Integer> Mj = new ArrayList<Integer>();

			for(int i : M) {

				if(i % (k + 1) == j ) {
					// Add i from M in Mj only if the rest is j
					Mj.add(i);
				}

			}

			if(j == 1) {
				// Particular case : k + 1 is contained by M1
				Mj.add(k + 1);
			}


			findPrimes[j] = new FindPrimes2(Mj, j);
			// Create a new thread with the multitude Mj
			// and j (to know which thread is it) as parameters

			findPrimes[j].start();
			// Start the thread's execution
		}


	}

}
