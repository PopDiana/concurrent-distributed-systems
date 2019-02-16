import java.util.ArrayList;

public class FindPrimes2 extends Thread {


	private ArrayList<Integer> M;
	private int j;


	public FindPrimes2(ArrayList<Integer> M, int j) {
		this.M = M;
		this.j = j;
	}

	public static boolean isAPrimeNumber(int x) {
		if ( x == 1 ) {
	        return false;

	    }else {

	        for(int i = 2 ; i <= Math.sqrt(x) ; ++i) {
	            if ( x % i == 0 ) {
	            	return false;
	            }
	        }

	    }

	    return true;
	}



	public void run() {

		for(int i : M) {

			if(isAPrimeNumber(i)) {

				System.out.println(i);
			}

		}

		long endTime = System.nanoTime();


		long executionTime = (endTime - Solution2.startTime) % 1000000;


		System.out.println("Primes in M" + j + " found after " + executionTime + " miliseconds");

	}


}
