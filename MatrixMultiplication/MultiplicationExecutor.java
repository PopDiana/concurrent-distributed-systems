import java.util.concurrent.Executor;

public class MultiplicationExecutor implements Executor {

	public void execute(Runnable command) {

		Thread multiplier = new Thread(command);
		multiplier.start();

	}

}
