import java.util.ArrayList;

public class Philosopher extends Thread{

	private Boolean dummy;
	private String name;
	private int leftFork;
	private int rightFork;
	private ArrayList<Channel<Boolean>> forks;


	public Philosopher(int leftFork, int rightFork, String name, ArrayList<Channel<Boolean>> forks2) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.forks = forks2;
		this.name = name;
	}

	public void run() {

		while(true) {


			try {
				System.out.println(name + " is thinking");
				Thread.sleep(1000);
				dummy = (forks.get(leftFork)).receive();
				dummy = (forks.get(rightFork)).receive();
				System.out.println(name + " is eating");
				Thread.sleep(1000);
				(forks.get(leftFork)).send(true);
				(forks.get(rightFork)).send(true);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
}
