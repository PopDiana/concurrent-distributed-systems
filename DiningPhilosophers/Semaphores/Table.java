import java.util.concurrent.Semaphore;

public class Table {

	private Semaphore forks[] = new Semaphore[5];


	public Table() {

		for(int i = 0 ; i <= 4 ; ++i) {
			forks[i] = new Semaphore(1);
		}
	}


	public void eat(int leftFork, int rightFork, String name) {


		try {
			forks[leftFork].acquire();
			forks[rightFork].acquire();
		} catch (InterruptedException e1) {

			e1.printStackTrace();
		}

		try{

			System.out.println(name + " eating");

            Thread.sleep(1000);

		}catch (InterruptedException e) {

           e.printStackTrace();
       }

		System.out.println(name + " is done eating and now is thinking");

		forks[leftFork].release();
		forks[rightFork].release();

	}


	public void think(String name) {

		try {

			System.out.println(name + " thinking");
            Thread.sleep(1000);

        } catch (InterruptedException e) {

            e.printStackTrace();
        }

	}

}
