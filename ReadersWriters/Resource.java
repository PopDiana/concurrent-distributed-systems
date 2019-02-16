import java.util.concurrent.Semaphore;

public class Resource {

	private int readCount = 0;
	private Semaphore resourceAccess = new Semaphore(1);
	private Semaphore readCountAccess = new Semaphore(1);
	private Semaphore serviceQueue = new Semaphore(1);

	public void write(int writerNumber) {


		// Obtaining access to the resource

		try {
			serviceQueue.acquire();
			resourceAccess.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		serviceQueue.release();

		// Writing into the resource

		try {
			System.out.println("Writer " + writerNumber + " is accessing the resource");
			Thread.sleep(1000);
			System.out.println("Writer " + writerNumber + " stopped accessing the resource");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		resourceAccess.release();

	}


	public void read(int readerNumber) {

		// Obtaining access to the queue and the readCount variable

		try {
			serviceQueue.acquire();
			readCountAccess.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}


		// First reader obtains access to the resource
		// so that writers are blocked

		if(readCount == 0) {
			try {
				resourceAccess.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		// Reader starts reading
		readCount++;

		serviceQueue.release();
		readCountAccess.release();

		// Reading the resource
		try {
			System.out.println("Reader " + readerNumber + " is accessing the resource");
			Thread.sleep(1000);
			System.out.println("Reader " + readerNumber + " stopped accessing the resource");
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}

		// Obtaining access to modify readCount

		try {
			readCountAccess.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// Reader stops reading
		readCount--;


		// Releasing access if the current reader is the last reader

		if(readCount == 0) {
			resourceAccess.release();
		}

		readCountAccess.release();
	}

}
