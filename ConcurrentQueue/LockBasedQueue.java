import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockBasedQueue {

	private volatile int head = 0;
	private volatile int tail = 0;
	private int[] elementsList;
	private Lock queueLock = new ReentrantLock();
	private Condition notFull = queueLock.newCondition();
	private Condition notEmpty = queueLock.newCondition();


	public LockBasedQueue(int maximumLength) {
		elementsList = new int[maximumLength];
	}


	public int deq() {

		int elementValue = 0;

		queueLock.lock();
		try {
			while (tail == head) // The queue is empty
				try {
					notEmpty.await(); // Wait for an element to be added in the queue
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			elementValue = elementsList[head % elementsList.length];
			head++;


			// An element has been removed, thus the queue is not full
			notFull.signal();

		} finally {
			queueLock.unlock();
		}
		return elementValue;
	}


	public void enq(int elementValue, int producerNumber) {

		queueLock.lock();

		try {
			while (tail - head == elementsList.length) // The queue is full
				try {
					notFull.await();  // Wait for an element to be removed from the queue
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			elementsList[tail % elementsList.length] = elementValue;
			System.out.println("Producer "+ producerNumber +" produced "
			+ elementValue + " on queue index " + tail % elementsList.length);
			tail++;


			// An element has been added, thus the queue is not empty
			notEmpty.signal();

		} finally {
			queueLock.unlock();
		}
	}

}
