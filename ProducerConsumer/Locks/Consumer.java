public class Consumer extends Thread {

	private int nrConsumers;
	private int number;
	private int Max;
	private int Min;
	private int counter = 0;
	private Market buffer;


	public Consumer(int nrConsumers, int number, int Min, int Max, Market buffer) {

		this.nrConsumers = nrConsumers;
		this.number = number;
		this.Min = Min;
		this.Max = Max;
		this.buffer = buffer;
	}


	public int getCounter() {
		return counter;
	}

	public void run() {

		int elementValue = Min;
		int element;

		while((elementValue % nrConsumers) != number) {
			elementValue++;
		}

		while(elementValue <= Max) {
			element = buffer.consume();

			if(element != -1) {
				System.out.println("Consumer " + number + " consumed " + element);
				counter++;
			}

			elementValue = elementValue + nrConsumers;

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

