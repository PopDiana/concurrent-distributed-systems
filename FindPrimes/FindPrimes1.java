
public class FindPrimes1 extends Thread {

	private int start;
	private int	end;

	public FindPrimes1(int start, int end) {

		this.start = start;
		this.end = end;

	}

	public static boolean isAPrimeNumber(int x) {

		if( x == 1 ) {
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


		for(int i = start ; i <= end ; ++i) {

			if(isAPrimeNumber(i)) {

				System.out.println(i);
			}

		}

		long endTime = System.nanoTime();
		long executionTime = (endTime - Solution1.startTime) % 1000000;

		System.out.println("Primes from interval [" + start + " , " + end + "] found after " + executionTime + " miliseconds");

	}





}
