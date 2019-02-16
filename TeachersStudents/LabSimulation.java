package semaphores;

public class LabSimulation {

	
	public static void main(String[] args) {
		
		Lab lab = new Lab();
		Teacher teacher1 = new Teacher(lab, 1);
		Teacher teacher2 = new Teacher(lab, 2);
		Teacher teacher3 = new Teacher(lab, 3);
		Student student1 = new Student(lab, 1);
		Student student2 = new Student(lab, 2);
		Student student3 = new Student(lab, 3);
		Student student4 = new Student(lab, 4);
		Student student5 = new Student(lab, 5);
		
		teacher1.start();
		teacher2.start();
		teacher3.start();
		student1.start();
		student2.start(); 
		student3.start();
		student4.start();
		student5.start();
		
		try {
			teacher1.join();
			teacher2.join();
			teacher3.join();
			student1.join();
			student2.join(); 
			student3.join();
			student4.join();
			student5.join();
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

}
