import java.util.concurrent.locks.ReentrantLock;

public class Market {

	private final int N = 5;
	private int oldest = 0;
	private int newest = 0;
	private volatile int count = 0;
	private int buffer[] = new int[N];
	private ReentrantLock bufferLock = new ReentrantLock();
	private boolean notFull = true;
	private boolean notEmpty = false;


	public void produce(int value) {

		bufferLock.lock();

		try {
			if(notFull) {

				buffer[newest] = value;
				newest = (newest + 1) % N;
				count++;

			}
			if(count == N) {

				notFull = false;
			}
			notEmpty = true;

		} finally {

			bufferLock.unlock();
		}

	}


	public int consume() {

		int value = -1;

		bufferLock.lock();
		try {
			if(notEmpty) {
				value = buffer[oldest];
				oldest = (oldest + 1) % N;
				count--;

			}
			if(count == 0) {
				notEmpty = false;
			}
			notFull = true;
		} finally {

			bufferLock.unlock();

		}
		return value;
	}
}


