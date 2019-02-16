public class Market {


	private final int N = 5;
	private int oldest = 0;
	private int newest = 0;
	private volatile int count = 0;
	private int buffer[] = new int[N];

	public synchronized void produce(int value) {

		while (count == N) {
			try {
				wait();
			} catch
			(InterruptedException e){}
		}
		buffer[newest] = value;
		newest = (newest + 1) % N;
		count++;
		notifyAll();
	}

	public synchronized int consume() {
		int value;
		while (count == 0) {
			try {
				wait();
			} catch
			(InterruptedException e){}
		}
		value = buffer[oldest];
		oldest = (oldest + 1) % N;
		count--;
		notifyAll();
		return value;
	}
}

