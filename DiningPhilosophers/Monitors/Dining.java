public class Dining {


	public static void main(String args[]) {

		// Create the monitor

		Table table = new Table();


		// Create the philosophers

		Philosopher plato = new Philosopher(4, 0, "first", table);
		Philosopher aristotle = new Philosopher(0, 1, "second", table);
		Philosopher descartes = new Philosopher(1, 2, "third", table);
		Philosopher confucius = new Philosopher(2, 3, "fourth", table);
		Philosopher socrates = new Philosopher(3, 4, "fifth", table);


		// Starting the threads' execution

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
