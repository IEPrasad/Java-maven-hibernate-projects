package main;

import dao.IStudentDao;
import dao.StudentDao;
import model.Student;

public class App {

    public static void main(String[] args) {

        IStudentDao dao = new StudentDao();

        Student student = new Student("Yahesha", "Jayasekara", "yahesha@gmail.com");
        dao.saveStudent(student);
        
        Student student1 = new Student("Yahesha", "Jayasekara", "yahesha@gmail.com");
        dao.saveStudent(student1);
        
        Student student2 = new Student("Yahesha", "Jayasekara", "yahesha@gmail.com");
        dao.saveStudent(student2);

        dao.updateStudent(student);
        dao.updateStudent(student1);
        dao.updateStudent(student2);

        dao.getAllStudents().forEach(s ->
                System.out.println(s.getFirstName()));

        //dao.deleteStudent(student.getId());
    }
}
