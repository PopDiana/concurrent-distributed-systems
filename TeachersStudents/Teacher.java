package semaphores;

public class Teacher extends Thread {
	private Lab lab;
	private int number;
	public void run(){
		while(true) {
		lab.enterTeacher();
		System.out.println("Teacher " + number + " entered the lab");
		
		lab.exitTeacher();
		System.out.println("Teacher " + number + " exited the lab");
		}
	}
	
	public Teacher(Lab lab, int number){
		this.lab = lab;
		this.number = number;
	}
}
