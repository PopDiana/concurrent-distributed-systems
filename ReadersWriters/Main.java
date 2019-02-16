import java.util.Scanner;

public class Main {


	public static void main(String[] args) {

		Resource resource = new Resource();

		Scanner scanner = new Scanner(System.in);

		System.out.println("How many readers will share the resource?");

		int readersNumber = scanner.nextInt();


		System.out.println("How many writers will share the resource?");

		int writersNumber = scanner.nextInt();

		scanner.close();

		Reader[] readers = new Reader[readersNumber + 1];


		// Initializing the readers

		for(int i = 1 ; i <= readersNumber ; ++i) {
			readers[i] = new Reader(i, resource);
		}

		Writer[] writers = new Writer[writersNumber + 1];


		// Initializing the writers

		for(int i = 1 ; i <= writersNumber ; ++i) {
			writers[i] = new Writer(i, resource);
		}


		// Starting the threads' execution

		for(int i = 1 ; i <= readersNumber ; ++i) {
			readers[i].start();
		}

		for(int i = 1 ; i <= writersNumber ; ++i) {
			writers[i].start();
		}

		for(int i = 1 ; i <= readersNumber ; ++i) {
			try {
				readers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for(int i = 1 ; i <= writersNumber ; ++i) {
			try {
				writers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
