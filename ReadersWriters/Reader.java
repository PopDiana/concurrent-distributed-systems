
public class Reader extends Thread{

	private int readerNumber;
	private Resource sharedResource;

	public Reader(int number, Resource resource) {
		readerNumber = number;
		sharedResource = resource;
	}

	public void run() {

		while(true) {
			sharedResource.read(readerNumber);
		}
	}

}
