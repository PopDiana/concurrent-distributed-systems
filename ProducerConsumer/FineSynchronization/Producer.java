public class Producer implements Runnable {


	private SharedQueue queue;
	private int number;

	public Producer(SharedQueue queue, int number) {

		this.queue = queue;
		this.number = number;
	}

	public void run() {

		int elementValue = number;
		while(true) {

			queue.enqueue(elementValue);
			System.out.println("Producer "+number+" produced "+ elementValue);
			elementValue+= number;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}


