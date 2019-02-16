import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedQueue {

	private final int maximumLength = 5;
	private LinkedList<Integer> elementsList = new LinkedList<Integer>();
	private ReentrantLock cellLock[] = new ReentrantLock[maximumLength];
	private ReentrantLock queueLock = new ReentrantLock();
	Condition notFull = queueLock.newCondition();
	Condition notEmpty = queueLock.newCondition();


	public SharedQueue() {
		for(int i = 0 ; i < maximumLength ; ++i) {
			cellLock[i] = new ReentrantLock();
		}
	}

	public void enqueue(int value) {

		int cell = elementsList.size();
		cellLock[cell].lock();


		try {

			if(elementsList.size() != maximumLength) {
				elementsList.push(value);
				notEmpty.signal();
			}else {
				while(elementsList.size() == maximumLength){
					try {
						notFull.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				elementsList.push(value);
				notEmpty.signal();
			}

		} finally {

			cellLock[cell].unlock();

		}


	}

	public int dequeue() {

		int value = -1;
		int cell = elementsList.size();
		cellLock[cell].lock();
		try {
			if(elementsList.size() != 0) {
				value = elementsList.pop();
				notFull.signal();
			}else {
				while(elementsList.size() == 0) {
					try {
						notEmpty.await();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				value = elementsList.pop();
				notFull.signal();
			}


		} finally {
			cellLock[cell].unlock();
		}
		return value;
	}
}


