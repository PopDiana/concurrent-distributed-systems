import java.util.concurrent.Executor;

public class ConsumerExecutor implements Executor{

	public void execute(Runnable command) {

		Thread consumer = new Thread(command);
		consumer.start();
	}


}
