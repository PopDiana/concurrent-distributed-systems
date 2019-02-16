package semaphores;

public class Student extends Thread {
		
	private Lab lab;
	private int number;
	
	public void run(){
		while(true){
		lab.enterStudent();
		System.out.println("Student " + number + " entered the lab");
		
		lab.exitStudent();
		System.out.println("Student " + number + " exited the lab");
		}
	}
	
	public Student(Lab lab, int number){
		this.lab = lab;
		this.number = number;
	}
}
