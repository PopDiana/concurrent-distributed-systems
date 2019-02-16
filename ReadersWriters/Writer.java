public class Writer extends Thread {

	private int writerNumber;
	private Resource sharedResource;


	public Writer(int number, Resource resource) {
		writerNumber = number;
		sharedResource = resource;
	}

	public void run() {

		while(true) {
			sharedResource.write(writerNumber);
		}
	}

}
