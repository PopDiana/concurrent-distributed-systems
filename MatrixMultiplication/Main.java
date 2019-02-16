import java.util.Random;


public class Main {

	public static final int MATRIX_SIZE = 1024;
	public static int A[][] = new int[MATRIX_SIZE][MATRIX_SIZE];
	public static int B[][] = new int[MATRIX_SIZE][MATRIX_SIZE];
	public static volatile int C[][] = new int[MATRIX_SIZE][MATRIX_SIZE];

	public static void main(String[] args) {


		// Getting the number of available virtual processors

		int workingThreads = Runtime.getRuntime().availableProcessors();


		System.out.println("Working threads : " + workingThreads);

		// Randomly generating the matrices

		Random rand = new Random();

		for(int i = 0 ; i < MATRIX_SIZE ; ++i) {
			for(int j = 0 ; j < MATRIX_SIZE ; ++j) {

				A[i][j] = rand.nextInt(50);
				B[i][j] = rand.nextInt(50);

			}
		}

		// Printing the matrices

		System.out.println("Matrix A : \n");

		for(int i = 0 ; i < MATRIX_SIZE ; ++i) {
			for(int j = 0 ; j < MATRIX_SIZE ; ++j) {

				System.out.print(A[i][j] + " ");

			}

			System.out.println();
		}

		System.out.println("\nMatrix B : \n");

		for(int i = 0 ; i < MATRIX_SIZE ; ++i) {
			for(int j = 0 ; j < MATRIX_SIZE ; ++j) {

				System.out.print(B[i][j] + " ");

			}

			System.out.println();
		}


		// Splitting the matrices and assigning work

		int range = MATRIX_SIZE / workingThreads;

		for(int i = 0 ; i < workingThreads ; ++i) {
			(new MultiplicationExecutor()).execute(new Multiplier(i, range, A, B, MATRIX_SIZE));
		}


		while(Multiplier.finished() != workingThreads) {
			// Do nothing while all threads aren't finished
		}



		// Printing the result matrix

		System.out.println("\nMatrix C : \n");

		for(int i = 0 ; i < MATRIX_SIZE ; ++i) {
			for(int j = 0 ; j < MATRIX_SIZE ; ++j) {

				System.out.print(C[i][j] + " ");

			}

			System.out.println();
		}



	}

}
