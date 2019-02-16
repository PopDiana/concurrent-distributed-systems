public class Main {

	public static void main(String[] args) {

		LockBasedQueue queue = new LockBasedQueue(5);

		Producer producer1 = new Producer(queue, 1);
		Producer producer2 = new Producer(queue, 2);
		Consumer consumer1 = new Consumer(queue, 1);
		Consumer consumer2 = new Consumer(queue, 2);

		producer1.start();
		producer2.start();
		consumer1.start();
		consumer2.start();

		try {
			producer1.join();
			producer2.join();
			consumer1.join();
			consumer2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
