import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Dining {


	public static void main(String[] args) {


		// Creating the array of locks for accessing the forks
	    Lock forks[] = new ReentrantLock[5];


	    for(int i = 0 ; i < 5 ; ++i) {
	        forks[i] = new ReentrantLock();
	    }


	    // Creating the philosophers

	    Philosopher plato = new Philosopher(forks[4], forks[0], "first");
	    Philosopher aristotle = new Philosopher(forks[0], forks[1], "second");
	    Philosopher descartes = new Philosopher(forks[1], forks[2], "third");
	    Philosopher confucius = new Philosopher(forks[2], forks[3], "fourth");
	    Philosopher socrates = new Philosopher(forks[3], forks[4], "fifth");


	    // Starting the thread's execution

	    plato.start();
	    aristotle.start();
	    descartes.start();
	    confucius.start();
	    socrates.start();

	    try {
			plato.join();
			aristotle.join();
		    descartes.join();
		    confucius.join();
		    socrates.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


	}
}
