package main;

import java.util.List;

import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

public class App {
	
	/**
	*@param args
	*/
	public static void main(String[] args) {
		
		IStudentDao studentDao = new StudentDao();
		
		
		// test saveStudent 
		Student student = new Student(0, "Ramesh", "Gupta", "ramesh@gmail.com");
		Student student3 = new Student(3, "Ra3mesh", "G3upta", "rames3h@gmail.com");
		studentDao.saveStudent(student);
		studentDao.saveStudent(student3);
		
		// test updateStudent 
		student.setFirstName("Ram");
		studentDao.updateStudent(student);
		
		// test getStudentById
		Student student2 = studentDao.getStudentById(student.getId());
		
		// test getAllStudents 
		List<Student> students = studentDao.getAllStudents();
		if (students != null) {
		    students.forEach(student1 -> System.out.println("Student ID: " + student1.getId()));
		} else {
		    System.out.println("No students found or an error occurred.");
		}
	
		// test deleteStudent
		studentDao.deleteStudent(student.getId());
	}
}
