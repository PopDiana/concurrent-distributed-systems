public class Consumer implements Runnable {

	private int number;
	private SharedQueue queue;

	public Consumer(SharedQueue queue, int number) {

		this.number = number;
		this.queue = queue;
	}

	public void run() {

		while(true) {

			int elementValue = queue.dequeue();

			System.out.println("Consumer " + number + " consumed " + elementValue);


			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}

