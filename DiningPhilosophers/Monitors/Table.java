public class Table {


	private boolean forks[] = new boolean[5];


	public synchronized void eat(int leftFork, int rightFork, String name) {


		// Waiting for both forks to be put down

		while(forks[leftFork] || forks[rightFork]) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Picking up the forks

		forks[leftFork] = forks[rightFork] = true;


		try{

			System.out.println(name + " eating");

            Thread.sleep(1000);

		}catch (InterruptedException e) {

           e.printStackTrace();
       }

		// Putting down the forks

		forks[leftFork] = forks[rightFork] = false;
		System.out.println(name + " is done eating and now is thinking");

		notify();

	}

	public synchronized void think(String name) {

		try {

			System.out.println(name + " thinking");
            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

	}

}
