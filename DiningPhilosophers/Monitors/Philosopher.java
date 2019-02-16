public class Philosopher extends Thread {


	private int leftFork;
	private int rightFork;
	private String name;
	private Table table;


	public Philosopher(int leftFork, int rightFork, String name, Table table) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.name = name;
		this.table = table;
	}


	public void run() {

		while(true) {
			table.think(name);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			table.eat(leftFork, rightFork, name);

		}

	}
}
