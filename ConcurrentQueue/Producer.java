public class Producer extends Thread {

	private LockBasedQueue queue;
	private int number;


	public Producer(LockBasedQueue queue, int number) {

		this.queue = queue;
		this.number = number;
	}

	public void run() {

		int elementValue = number;
		while(true) {

			queue.enq(elementValue,number);
			elementValue = elementValue + number;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

	}

}
