public class Producer extends Thread {

	private int nrProducers;
	private int number;
	private int Max;
	private int Min;
	private Market buffer;
	private int counter = 0;

	public Producer(int nrProducers, int number, int Min, int Max, Market buffer) {
		this.nrProducers = nrProducers;
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

		while((elementValue % nrProducers) != number) {
			elementValue++;
		}

		while(elementValue <= Max) {
			buffer.produce(elementValue);
			counter++;
			System.out.println("Producer "+number+" produced "+elementValue);
			elementValue = elementValue + nrProducers;
		}
	}
}

