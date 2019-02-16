public class Main {

	public static void main(String[] args) {


		SharedQueue queue = new SharedQueue();

		int nrProducers = 4;

		int nrConsumers = Runtime.getRuntime().availableProcessors();



		for(int i = 1 ; i <= nrProducers ; ++i) {
			ProducerExecutor prodExec = new ProducerExecutor();
			prodExec.execute(new Producer(queue, i));
		}

		for(int i = 1 ; i <= nrConsumers ; ++i) {
			ConsumerExecutor consExec = new ConsumerExecutor();
			consExec.execute(new Consumer(queue, i));
		}


	}
}
