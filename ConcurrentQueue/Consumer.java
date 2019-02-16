public class Consumer extends Thread {


	private int number;
	private LockBasedQueue queue;


	public Consumer(LockBasedQueue queue, int number) {

		this.number = number;
		this.queue = queue;
	}

	public void run() {

		while(true) {

			int elementValue = 0;

			elementValue = queue.deq();
			System.out.println("Consumer " + number + " consumed " + elementValue);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
