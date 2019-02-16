import java.util.Scanner;

public class Solution1 {

	public static long startTime;

	public static void main(String[] args) {


		Scanner scan = new Scanner(System.in);

		System.out.println("n = ");

		int n = scan.nextInt();


		System.out.println("k = ");

		int k = scan.nextInt();


		scan.close();


		startTime = System.nanoTime();

		int q = n / k;

		FindPrimes1[] findPrimes = new FindPrimes1[k];


		for(int j = 0 ; j < k ; ++j) {
			// There are k intervals

			int start = j * q + 1;
			int end = q * ( j + 1 );
			// Compute the minimum and maximum number of each interval

			findPrimes[j] = new FindPrimes1(start , end);
			// Create a new thread with minimum
			// and maximum number as parameters

			findPrimes[j].start();
			// Start the thread's execution
		}


	}

}
