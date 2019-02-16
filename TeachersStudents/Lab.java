package semaphores;

import java.util.concurrent.Semaphore;



public class Lab {
	private int students = 0;
	private int teachers = 0;

	private Semaphore studentSemaphore = new Semaphore(1);

	private Semaphore teacherSemaphore = new Semaphore(1);

	public void enterStudent(){

		try {
			studentSemaphore.acquire();
			//nrStudents.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		students++;

		if(students == 1){
			try {
				teacherSemaphore.acquire();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("teachers = " + teachers + " students = " + students);

		studentSemaphore.release();
	}

	public void enterTeacher() {

		try {
			teacherSemaphore.acquire();
			//nrTeachers.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		teachers++;
		try {
			studentSemaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("teachers = " + teachers + " students = " + students);

		teacherSemaphore.release();
	}

	public void exitTeacher(){

		try {
			teacherSemaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		teachers--;
		System.out.println("teachers = " + teachers + " students = " + students);
		teacherSemaphore.release();
		//nrTeachers.release();
	}

	public void exitStudent(){
		try {
			studentSemaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		students--;


		if(students == 0){

			teacherSemaphore.release();

		}
		System.out.println("teachers = " + teachers + " students = " + students);
		studentSemaphore.release();
		//nrStudents.release();


	}
}
