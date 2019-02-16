import java.util.ArrayList;

public class Dining {
	
	public static void main(String[] args) {
		
		ArrayList<Channel<Boolean>> forks = new ArrayList<Channel<Boolean>>();
		
		for(int i = 0 ; i < 5 ; ++i) {
			forks.add(new Channel<Boolean>());
		}
						
		Philosopher plato = new Philosopher(4, 0, "first", forks);
		Philosopher aristotle = new Philosopher(0, 1, "second", forks);
		Philosopher descartes = new Philosopher(1, 2, "third", forks);
		Philosopher confucius = new Philosopher(2, 3, "fourth", forks);
		Philosopher socrates = new Philosopher(3, 4, "fifth", forks);
		
		
		Fork fork1 = new Fork(0, forks);
		Fork fork2 = new Fork(1, forks);
		Fork fork3 = new Fork(2, forks);
		Fork fork4 = new Fork(3, forks);
		Fork fork5 = new Fork(4, forks);
		
		fork1.start();
		fork2.start();
		fork3.start();
		fork4.start();
		fork5.start();
		
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
