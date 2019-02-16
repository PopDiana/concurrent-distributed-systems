import java.util.concurrent.Semaphore;

public class Market {

	private final int N = 5;
	private int oldest = 0;
	private int newest = 0;
	private volatile int count = 0;
	private int buffer[] = new int[N];
	private Semaphore producerSemaphore = new Semaphore(1);
	private Semaphore consumerSemaphore = new Semaphore(0);
	private Semaphore notFull = new Semaphore(1);
	private Semaphore notEmpty = new Semaphore(0);

	public void produce(int value) {

		try {
			producerSemaphore.acquire();
			notFull.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		buffer[newest] = value;
		newest = (newest + 1) % N;
		count++;

		if(count < N) {
			notFull.release();
		}

		if(count != 0) {
			notEmpty.release();
		}
		producerSemaphore.release();
		consumerSemaphore.release();
		notEmpty.release();

	}

	public int consume() {

		try {
			consumerSemaphore.acquire();
			notEmpty.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		int temp;
		temp = buffer[oldest];
		oldest = (oldest + 1) % N;
		count--;

		if(count != 0) {
			notEmpty.release();
		}

		if(count < N) {
			notFull.release();
		}
		consumerSemaphore.release();

		return temp;
	}
}
