import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Philosopher extends Thread {


	private Lock leftFork = new ReentrantLock();
	private Lock rightFork = new ReentrantLock();
	private String name;


	public Philosopher(Lock leftFork, Lock rightFork, String name) {

	    this.leftFork = leftFork;
	    this.rightFork = rightFork;
	    this.name = name;
	}


	public void run() {

		while(true) {

			think();
			eat();

		}
	}


	private void eat() {

		// Picking up the forks

	    leftFork.lock();
	    rightFork.lock();

	    try {
	    	System.out.println(name + " is eating");
	    	Thread.sleep(1000);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }

	    System.out.println(name + " is done eating and now is thinking");

	    // Putting down the forks

	    leftFork.unlock();
	    rightFork.unlock();
	}


	public void think() {

		try {

		   System.out.println(name + " is thinking");
	       Thread.sleep(1000);

	   } catch (InterruptedException e) {
	          e.printStackTrace();
	   }
	}
}

