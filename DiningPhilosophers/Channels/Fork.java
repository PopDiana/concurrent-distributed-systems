import java.util.ArrayList;

public class Fork extends Thread {

		private Boolean dummy;
		private int i;
		private ArrayList<Channel<Boolean>> forks;
		
		public Fork(int i, ArrayList<Channel<Boolean>> forks) {
			this.i = i;
			this.forks = forks;
		}
		public void run() {
			
			while(true) {
	
				try {
					(forks.get(i)).send(true);
					dummy = (forks.get(i)).receive();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
}
